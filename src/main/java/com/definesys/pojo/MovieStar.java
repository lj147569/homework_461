package com.definesys.pojo;

import com.definesys.mpaas.query.annotation.SQL;
import com.definesys.mpaas.query.annotation.SQLQuery;

@SQLQuery(value = {
        @SQL(view = "find_score",sql = "select * from find_score")
})
public class MovieStar {

    private double score;
    private double five;
    private double four;
    private double three;
    private double two;
    private double one;
    private Integer num;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getFive() {
        return five;
    }

    public void setFive(double five) {
        this.five = five;
    }

    public double getFour() {
        return four;
    }

    public void setFour(double four) {
        this.four = four;
    }

    public double getThree() {
        return three;
    }

    public void setThree(double three) {
        this.three = three;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(double two) {
        this.two = two;
    }

    public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
