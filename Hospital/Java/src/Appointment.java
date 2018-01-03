package Hospital;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Appointment {
  public String date;
  public String time;
  public String clientName;

  public void cg_init_Appointment_1(final String d, final String t, final String cN) {

    date = d;
    time = t;
    clientName = cN;
    return;
  }

  public Appointment(final String d, final String t, final String cN) {

    cg_init_Appointment_1(d, t, cN);
  }

  public void addDate(final String d) {

    date = d;
  }

  public void addTime(final String t) {

    time = t;
  }

  public String getDate() {

    return date;
  }

  public String getTime() {

    return time;
  }

  public String getClientName() {

    return clientName;
  }

  public Appointment() {}

  public String toString() {

    return "Appointment{"
        + "date := "
        + Utils.toString(date)
        + ", time := "
        + Utils.toString(time)
        + ", clientName := "
        + Utils.toString(clientName)
        + "}";
  }
}
