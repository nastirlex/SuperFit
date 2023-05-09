package com.nastirlex.superfit.net.repositoryImpl

import com.nastirlex.superfit.net.dto.TrainingDto
import com.nastirlex.superfit.net.repository.TrainingRepository
import com.nastirlex.superfit.net.service.TrainingService
import javax.inject.Inject

class TrainingRepositoryImpl @Inject constructor(private val trainingService: TrainingService) :
    TrainingRepository {
    override suspend fun getTrainings(): List<TrainingDto> {
        return trainingService.getTrainings()
    }
}