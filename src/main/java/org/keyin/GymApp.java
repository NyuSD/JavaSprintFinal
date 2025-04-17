package org.keyin;

import org.keyin.user.User;
import org.keyin.user.UserService;
import org.keyin.user.childclasses.Member;
import org.keyin.user.childclasses.Trainer;
import org.keyin.memberships.Membership;
import org.keyin.memberships.MembershipService;
import org.keyin.workoutclasses.WorkoutClass;
import org.keyin.workoutclasses.WorkoutClassService;
import java.util.List;

/**
 * Simple class to demonstrate DAO / Service calls.
 * In a real console application this would evolve into an interactive
 * menu but for now we hard‑code a scenario.
 */
public class GymApp {
    public static void main(String[] args) {

        UserService          userService   = new UserService();
        MembershipService    membrService  = new MembershipService();
        WorkoutClassService  classService  = new WorkoutClassService();

        // Register a member & trainer
        Member  member  = userService.createMember("john_doe","p@ss","john@example.com",
                                                   "123 Main","555‑1234");
        Trainer trainer = userService.createTrainer("jane_trainer","tpw",
                                                    "jane@fitness.com","456 Elm","555‑5678");
        System.out.println("Created member  : " + member);
        System.out.println("Created trainer : " + trainer);

        // Member buys membership
        Membership m = new Membership(0,"Monthly","Basic",49.99, member.getUserId());
        membrService.purchaseMembership(m);

        // Trainer schedules class
        WorkoutClass wc = new WorkoutClass(0,"Yoga","Morning Yoga", trainer.getUserId());
        classService.createWorkoutClass(wc);

        // Display summary
        System.out.println("\nAll users:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("\nAll memberships:");
        membrService.getAllMemberships().forEach(System.out::println);

        System.out.println("Total revenue = $" + membrService.getTotalRevenue());

        System.out.println("\nAll workout classes:");
        classService.getAllWorkoutClasses().forEach(System.out::println);
    }
}
