package Hospital;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Hospital {
  public String name;
  public VDMSet doctors = SetUtil.set();
  public VDMSet appointments = SetUtil.set();
  public Number nDoctors = 0L;
  public Number nAppoints = 0L;

  public void cg_init_Hospital_1(final String h) {

    name = h;
    return;
  }

  public Hospital(final String h) {

    cg_init_Hospital_1(h);
  }

  public String getName() {

    return name;
  }

  public VDMSet getDoctors() {

    return Utils.copy(doctors);
  }

  public Number getNAppoints() {

    return nAppoints;
  }

  public VDMSet getAppointments() {

    return Utils.copy(appointments);
  }

  public void addDoctors(final Doctor d) {

    doctors = SetUtil.union(Utils.copy(doctors), SetUtil.set(d));
  }

  public void addAppointments(final Appointment a) {

    appointments = SetUtil.union(Utils.copy(appointments), SetUtil.set(a));
  }

  public Hospital() {}

  public String toString() {

    return "Hospital{"
        + "name := "
        + Utils.toString(name)
        + ", doctors := "
        + Utils.toString(doctors)
        + ", appointments := "
        + Utils.toString(appointments)
        + ", nDoctors := "
        + Utils.toString(nDoctors)
        + ", nAppoints := "
        + Utils.toString(nAppoints)
        + "}";
  }
}
