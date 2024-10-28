package com.pruebatecnica.kuikoservice.service.implement;

import com.pruebatecnica.kuikoservice.dto.ProvinceDto;
import com.pruebatecnica.kuikoservice.dto.ProvinceDtoMapper;
import com.pruebatecnica.kuikoservice.model.Community;
import com.pruebatecnica.kuikoservice.model.Province;
import com.pruebatecnica.kuikoservice.repository.CommunityRepository;
import com.pruebatecnica.kuikoservice.repository.ProvinceRepository;
import com.pruebatecnica.kuikoservice.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;
    private final CommunityRepository communityRepository;

    @Override
    public List<ProvinceDto> getAllProvinces() {

        List<Province> provinces = provinceRepository.findAll();
        return provinces.stream()
                .map(province -> new ProvinceDto(province.getId(),province.getProvinceCode(), province.getProvinceName(),province.getCommunity().getCommunityCode()))
                .collect(Collectors.toList());
    }

    @Override
    public ProvinceDto getById(Long id) {

        Optional<Province> provinceOptional = provinceRepository.findById(id);
        if (!provinceOptional.isPresent()) {
            throw new NoSuchElementException("La provincia solicitada no existe");
        }

        Province province = provinceOptional.get();
        return ProvinceDtoMapper.toDto(province);
    }

    @Override
    public ProvinceDto createProvince(ProvinceDto provinceDto) {

        Province newProvince = new Province();
        newProvince.setProvinceCode(provinceDto.getProvinceCode());
        newProvince.setProvinceName(provinceDto.getProvinceName());

        Community community = communityRepository.findByCommunityCode(provinceDto.getCommunityCode())
                .orElseThrow(() -> new NoSuchElementException("El codigo de comunidad autonoma que desea dar de alta no fue encontrado"));
        newProvince.setCommunity(community);

        Province result = provinceRepository.save(newProvince);

        return ProvinceDtoMapper.toDto(result);

    }

    @Override
    public ProvinceDto updateProvince(Long id, ProvinceDto provinceDto) {

        Optional<Province> provinceOptional = provinceRepository.findById(id);
        if (!provinceOptional.isPresent()) {
            throw new NoSuchElementException("La provincia que desea actualizar no existe");
        }
        Province province =  provinceRepository.findById(id).get();
        province.setProvinceCode(provinceDto.getProvinceCode());
        province.setProvinceName(provinceDto.getProvinceName());

        Community community = communityRepository.findByCommunityCode(provinceDto.getCommunityCode())
                .orElseThrow(() -> new NoSuchElementException("El codigo de comunidad autonoma que desea actualizar no fue encontrado"));
        province.setCommunity(community);

        Province result = provinceRepository.save(province);

        return ProvinceDtoMapper.toDto(result);
    }

    @Override
    public void deleteProvince(Long id) {

        Optional<Province> provinceOptional = provinceRepository.findById(id);
        if (!provinceOptional.isPresent()) {
            throw new NoSuchElementException("La provincia que desea eliminar no existe");
        }
        provinceRepository.deleteById(id);
    }
}
