package org.keyin.workoutclasses;

/**
 * Entity representing a scheduled workout / class run by a trainer.
 * Maps to a row in <em>workoutclasses</em>.
 */
public class WorkoutClass {

    private int    workoutClassId;         // PK
    private String workoutClassType;       // "Yoga"
    private String workoutClassDescription;
    private int    trainerId;              

    public WorkoutClass() { }

    public WorkoutClass(int id, String type, String desc, int trainerId) {
        this.workoutClassId         = id;
        this.workoutClassType       = type;
        this.workoutClassDescription= desc;
        this.trainerId              = trainerId;
    }

    // getters / setters
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
        return "WorkoutClass[id=%d, type=%s, trainerId=%d]"
                .formatted(workoutClassId, workoutClassType, trainerId);
    }
}
