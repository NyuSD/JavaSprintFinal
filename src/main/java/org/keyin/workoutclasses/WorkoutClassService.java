package org.keyin.workoutclasses;

import java.util.List;

public class WorkoutClassService {
    private WorkoutClassDAO dao = new WorkoutClassDAO();

    public void createWorkoutClass(WorkoutClass wc) {
        dao.createWorkoutClass(wc);
    }

    public WorkoutClass getWorkoutClassById(int id) {
        return dao.getWorkoutClassById(id);
    }

    public List<WorkoutClass> getAllWorkoutClasses() {
        return dao.getAllWorkoutClasses();
    }

    public void updateWorkoutClass(WorkoutClass wc) {
        dao.updateWorkoutClass(wc);
    }

    public void deleteWorkoutClass(int id) {
        dao.deleteWorkoutClass(id);
    }
}
