package com.theatre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
public class Seats extends BaseEntity {

    @Column
    private int seatNo;

    @Column
    private String row;

    @Column
    private String seat_position;

    @Column
    private int total_seat;

    @Column
    private int start_seat_no;

    @Column
    private int end_seat_no;

    @Column
    private int total_columns;

    @Column
    private boolean is_extended;

    private Room room;

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeat_position() {
        return seat_position;
    }

    public void setSeat_position(String seat_position) {
        this.seat_position = seat_position;
    }

    public int getTotal_seat() {
        return total_seat;
    }

    public void setTotal_seat(int total_seat) {
        this.total_seat = total_seat;
    }

    public int getStart_seat_no() {
        return start_seat_no;
    }

    public void setStart_seat_no(int start_seat_no) {
        this.start_seat_no = start_seat_no;
    }

    public int getEnd_seat_no() {
        return end_seat_no;
    }

    public void setEnd_seat_no(int end_seat_no) {
        this.end_seat_no = end_seat_no;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public boolean isIs_extended() {
        return is_extended;
    }

    public void setIs_extended(boolean is_extended) {
        this.is_extended = is_extended;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
