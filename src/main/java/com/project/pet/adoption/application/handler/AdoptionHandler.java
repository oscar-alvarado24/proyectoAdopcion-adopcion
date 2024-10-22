package com.project.pet.adoption.application.handler;

import com.project.pet.adoption.application.dto.AdoptionCreateResponse;
import com.project.pet.adoption.application.dto.AdoptionResponse;
import com.project.pet.adoption.application.dto.AdoptionUpdateResponse;
import com.project.pet.adoption.application.dto.CreateAdoptionRequest;
import com.project.pet.adoption.application.dto.DeleteAdoptionRequest;
import com.project.pet.adoption.application.dto.DeleteAdoptionResponse;
import com.project.pet.adoption.application.dto.UpdateAdoptionRequest;
import com.project.pet.adoption.application.mapper.IAdoptionMapper;
import com.project.pet.adoption.domain.api.IAdoptionServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionHandler implements IAdoprionHandler{
    private final IAdoptionServicePort adoptionService;
    private final IAdoptionMapper adoptionMapper;
    /**
     * @param email of user to get adoptions
     * @return list adoptions
     */
    @Override
    public List<AdoptionResponse> getAdoptionsByEmail(String email) {
        return adoptionMapper.toAdoptionResponseList(adoptionService.getAdoptionsByEmail(email));
    }

    /**
     * @param adoptionRequest adoption to save
     * @return message of successfully creation and adoption id
     */
    @Override
    public AdoptionCreateResponse createAdoption(CreateAdoptionRequest adoptionRequest) {
        return adoptionMapper.toAdoptionCreateResponse(adoptionService.createAdoption(adoptionMapper.toAdoptionModelFromCreateAdoptionRequest(adoptionRequest)),String.valueOf(adoptionRequest.getPetId()), adoptionRequest.getEmail());
    }

    /**
     * @param adoptionRequest adoption id and adoption data ti update
     * @return message of successfully update
     */
    @Override
    public AdoptionUpdateResponse updateAdoption(UpdateAdoptionRequest adoptionRequest) {
        return adoptionMapper.toAdoptionUpdateResponse(adoptionService.updateAdoption(adoptionRequest.getId(),adoptionMapper.toAdoptionModel(adoptionRequest.getAdoptions(0))));
    }

    /**
     * @param adoptionRequest adoptionId to delete
     * @return message of successfully delete
     */
    @Override
    public DeleteAdoptionResponse deleteAdoption(DeleteAdoptionRequest adoptionRequest) {
        return adoptionMapper.toDeleteAdoptionResponse(adoptionService.deleteAdoption(adoptionRequest.getId()));
    }
}
