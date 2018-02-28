package com.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "time_test")
public class TimeTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIME_TEST_ID")
    private Long timeTestId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATETIME_COLUMN")
    private Date dateTimeColumn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP_COLUMN")
    private Date timestampColumn;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COLUMN")
    private Date dateColumn;

    @Temporal(TemporalType.TIME)
    @Column(name = "TIME_COLUMN")
    private Date timeColumn;

    @Column(name = "SQL_DATETIME_COLUMN")
    private Timestamp sqlDatetimeColumn;

    @Column(name = "SQL_TIMESTAMP_COLUMN")
    private Timestamp sqlTimestampColumn;

    @Column(name = "SQL_DATE_COLUMN")
    private java.sql.Date sqlDateColumn;

    @Column(name = "SQL_TIME_COLUMN")
    private Time sqlTimeColumn;


    public TimeTest(Date date) {
        this.dateTimeColumn = date;
        this.timestampColumn = date;
        this.dateColumn = date;
        this.timeColumn = date;

        this.sqlDatetimeColumn = new Timestamp(date.getTime());
        this.sqlTimestampColumn = new Timestamp(date.getTime());
        this.sqlDateColumn = new java.sql.Date(date.getTime());
        this.sqlTimeColumn = new Time(date.getTime());
    }



}
