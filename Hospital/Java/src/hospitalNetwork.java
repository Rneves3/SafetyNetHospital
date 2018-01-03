package Hospital;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class hospitalNetwork {
  public VDMSet hospitals = SetUtil.set();
  public VDMSet doctors = SetUtil.set();
  public VDMSet appointments = SetUtil.set();

  public void cg_init_hospitalNetwork_1() {

    return;
  }

  public hospitalNetwork() {

    cg_init_hospitalNetwork_1();
  }

  public VDMSet getHospitals() {

    return Utils.copy(hospitals);
  }

  public VDMSet getDoctors() {

    return Utils.copy(doctors);
  }

  public VDMSet getAppointments() {

    return Utils.copy(appointments);
  }

  public void addDoctors(final Doctor d) {

    doctors = SetUtil.union(Utils.copy(doctors), SetUtil.set(d));
  }

  public void addHospital(final Hospital h) {

    hospitals = SetUtil.union(Utils.copy(hospitals), SetUtil.set(h));
  }

  public void addAppointments(final Appointment a) {

    appointments = SetUtil.union(Utils.copy(appointments), SetUtil.set(a));
  }

  public VDMSet getHospitalDocs(final Hospital hosp) {

    return hosp.doctors;
  }

  public VDMSet getDocsMultipleHospitals() {

    VDMSet docs = SetUtil.set();
    VDMSet result = SetUtil.set();
    VDMSet intersect = SetUtil.set();
    for (Iterator iterator_1 = hospitals.iterator(); iterator_1.hasNext(); ) {
      Hospital h = (Hospital) iterator_1.next();
      docs = SetUtil.union(Utils.copy(docs), SetUtil.set(h.doctors));
    }
    for (Iterator iterator_2 = docs.iterator(); iterator_2.hasNext(); ) {
      VDMSet setDocs = (VDMSet) iterator_2.next();
      intersect = SetUtil.set();
      for (Iterator iterator_3 =
              SetUtil.diff(Utils.copy(docs), SetUtil.set(Utils.copy(setDocs))).iterator();
          iterator_3.hasNext();
          ) {
        VDMSet setDocsPrime = (VDMSet) iterator_3.next();
        intersect = SetUtil.intersect(Utils.copy(setDocs), Utils.copy(setDocsPrime));
        if (!(Utils.empty(intersect))) {
          result = SetUtil.union(Utils.copy(result), Utils.copy(intersect));
        }
      }
    }
    return Utils.copy(result);
  }

  public Hospital getHospitalMostAppointments() {

    Hospital hosp = null;
    Number max = 0L;
    for (Iterator iterator_4 = hospitals.iterator(); iterator_4.hasNext(); ) {
      Hospital h = (Hospital) iterator_4.next();
      if (h.appointments.size() > max.longValue()) {
        hosp = h;
        max = h.appointments.size();
      }
    }
    return hosp;
  }

  public String toString() {

    return "hospitalNetwork{"
        + "hospitals := "
        + Utils.toString(hospitals)
        + ", doctors := "
        + Utils.toString(doctors)
        + ", appointments := "
        + Utils.toString(appointments)
        + "}";
  }
}
