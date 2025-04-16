package org.keyin.workoutclasses;

public class WorkoutClass {
    private int workoutClassId;
    private String workoutClassType;
    private String workoutClassDescription;
    private int trainerId;

    public WorkoutClass() {}

    public WorkoutClass(int workoutClassId, String workoutClassType,
                        String workoutClassDescription, int trainerId) {
        this.workoutClassId = workoutClassId;
        this.workoutClassType = workoutClassType;
        this.workoutClassDescription = workoutClassDescription;
        this.trainerId = trainerId;
    }

    public int getWorkoutClassId() {
        return workoutClassId;
    }
    public String getWorkoutClassType() {
        return workoutClassType;
    }
    public String getWorkoutClassDescription() {
        return workoutClassDescription;
    }
    public int getTrainerId() {
        return trainerId;
    }

    public void setWorkoutClassId(int workoutClassId) {
        this.workoutClassId = workoutClassId;
    }
    public void setWorkoutClassType(String workoutClassType) {
        this.workoutClassType = workoutClassType;
    }
    public void setWorkoutClassDescription(String workoutClassDescription) {
        this.workoutClassDescription = workoutClassDescription;
    }
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public String toString() {
        return "WorkoutClass [id=" + workoutClassId 
             + ", type=" + workoutClassType 
             + ", desc=" + workoutClassDescription 
             + ", trainerId=" + trainerId + "]";
    }
}
