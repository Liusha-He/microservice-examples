package com.liusha.coursecatalogapi.service

import com.liusha.coursecatalogapi.dto.InstructorDTO
import com.liusha.coursecatalogapi.entity.Instructor
import com.liusha.coursecatalogapi.repository.InstructorRepo
import org.springframework.stereotype.Service

@Service
class InstructorService(val instructorRepo: InstructorRepo) {
    fun createInstructor(instructorDTO: InstructorDTO): InstructorDTO {
        val instructorEntity = instructorDTO.let {
            Instructor(it.id, it.name)
        }
        instructorRepo.save(instructorEntity)

        return instructorEntity.let {
            InstructorDTO(it.id, it.name)
        }
    }
}