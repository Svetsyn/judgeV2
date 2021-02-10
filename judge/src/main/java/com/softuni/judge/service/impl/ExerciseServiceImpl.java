package com.softuni.judge.service.impl;

import com.softuni.judge.model.entity.Exercise;
import com.softuni.judge.model.service.ExerciseServiseModel;
import com.softuni.judge.repository.ExerciseRepository;
import com.softuni.judge.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiseModel exerciseServiseModel) {
        exerciseRepository.save(
                modelMapper
                        .map(exerciseServiseModel, Exercise.class)
        );
    }
}
