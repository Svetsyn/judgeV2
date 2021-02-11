package com.softuni.judge.service;

import com.softuni.judge.model.service.ExerciseServiseModel;

import java.util.List;

public interface ExerciseService {
    void addExercise(ExerciseServiseModel exerciseServiseModel);

    List<String> findAllnames();

    boolean checkIsLate(String exercise);
}
