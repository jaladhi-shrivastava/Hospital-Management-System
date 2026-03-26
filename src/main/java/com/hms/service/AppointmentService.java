package com.hms.service;

import com.hms.entity.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Integer id);
    Appointment updateAppointment(Integer id, Appointment appointment);
    void deleteAppointment(Integer id);
}