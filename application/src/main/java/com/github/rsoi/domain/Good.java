package com.github.rsoi.domain;

import com.github.rsoi.repository.MarkRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Good {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String Name;
    int orderAmount;
    float averageMark;

    public float getAverageMark(int CURRENT_MONTH, ArrayList<Mark> marks) {
        int totalMark = 0;
        int average = 0;

        if (orderAmount > 100) {
            for (Mark mark : marks) {
                totalMark = totalMark + mark.getMark();
            }
        } else {
            for (Mark mark : marks) {
                if (mark.getDate() > CURRENT_MONTH - 3)
                    totalMark = totalMark + mark.getMark();
            }
        }
        if (marks.size() != 0) average = totalMark / marks.size();
        return average;
    }
}
