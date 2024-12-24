package com.hospitalManagment.Repositories;

import com.hospitalManagment.Entities.scheduleAppointment;
import com.hospitalManagment.Entities.scheduleStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface scheduleAppointmentRepository extends JpaRepository<scheduleAppointment,Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE scheduleAppointment s SET s.scheduleStatus= :scheduleStatus WHERE s.scheduleId= :scheduleId")
    public int updateScheduleAppointmentStatusByScheduleId(@Param("scheduleId") Integer scheduleId,@Param("scheduleStatus") scheduleStatus scheduleStatus);
}
