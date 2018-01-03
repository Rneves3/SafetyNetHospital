package Hospital;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Doctor {
  public String name;
  public VDMSet hospitals = SetUtil.set();
  public VDMSet appointments = SetUtil.set();
  public Number nHospitals = 0L;

  public void cg_init_Doctor_1(final String d) {

    name = d;
    return;
  }

  public Doctor(final String d) {

    cg_init_Doctor_1(d);
  }

  public String getName() {

    return name;
  }

  public VDMSet getHospitals() {

    return Utils.copy(hospitals);
  }

  public VDMSet getAppointments() {

    return Utils.copy(appointments);
  }

  public void addHospital(final Hospital h) {

    hospitals = SetUtil.union(Utils.copy(hospitals), SetUtil.set(h));
  }

  public void addAppointments(final Appointment a) {

    appointments = SetUtil.union(Utils.copy(appointments), SetUtil.set(a));
  }

  public Doctor() {}

  public String toString() {

    return "Doctor{"
        + "name := "
        + Utils.toString(name)
        + ", hospitals := "
        + Utils.toString(hospitals)
        + ", appointments := "
        + Utils.toString(appointments)
        + ", nHospitals := "
        + Utils.toString(nHospitals)
        + "}";
  }
}
