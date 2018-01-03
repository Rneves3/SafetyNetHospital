package Hospital;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class hospitalNetworkTest extends MyTestCase {
  private hospitalNetwork network = new hospitalNetwork();
  private Doctor doctor1 = new Doctor("Ricardo");
  private Doctor doctor2 = new Doctor("Joana");
  private Doctor doctor3 = new Doctor("Jose");
  private Hospital hospital1 = new Hospital("S.Jon");
  private Hospital hospital2 = new Hospital("S.Jose");
  private Hospital hospital3 = new Hospital("CUF");
  private Hospital hospital4 = new Hospital("Coimbra");
  private Hospital hospital5 = new Hospital("S.Maria");
  private Hospital hospital6 = new Hospital("Arrabida");
  private Appointment appointment1 = new Appointment("21-01-2018", "15:30", "Ernesto");
  private Appointment appointment2 = new Appointment("11-05-2018", "11:30", "Amelia");
  private Appointment appointment3 = new Appointment("08-02-2018", "15:00", "Gertrudes");
  private Appointment appointment4 = new Appointment("30-01-2018", "16:30", "Arnaldo");

  public void testAddDoctor() {

    network.addDoctors(doctor3);
    super.assertTrue(SetUtil.inSet(doctor3, network.getDoctors()));
  }

  public void testAllDoctor() {

    testAddDoctor();
  }

  public void testGetHospitalDocs() {

    hospitalNetwork ms = new hospitalNetwork();
    Hospital h1 = new Hospital("H.S.Joao");
    Doctor doc1 = new Doctor("Bela");
    Doctor doc2 = new Doctor("Bia");
    VDMSet expected = SetUtil.set(doc1, doc2);
    IO.println("running testGetHospitalDocs");
    h1.addDoctors(doc1);
    h1.addDoctors(doc2);
    ms.hospitals = SetUtil.union(ms.hospitals, SetUtil.set(h1));
    super.assertEqual(Utils.copy(expected), ms.getHospitalDocs(h1));
  }

  public void testGetDocsMultipleHospitals() {

    hospitalNetwork ms = new hospitalNetwork();
    Hospital h1 = new Hospital("H.S.Joao");
    Hospital h2 = new Hospital("Sta. Maria");
    Hospital h3 = new Hospital("Agostinho Neto");
    Doctor doc1 = new Doctor("Bela");
    Doctor doc2 = new Doctor("Bia");
    Doctor doc3 = new Doctor("Eva");
    VDMSet expected = SetUtil.set(doc3, doc1);
    IO.println("running testGetDocsMultipleHospitals");
    h1.addDoctors(doc1);
    h1.addDoctors(doc2);
    h2.addDoctors(doc1);
    h3.addDoctors(doc3);
    h2.addDoctors(doc3);
    ms.hospitals = SetUtil.union(ms.hospitals, SetUtil.set(h1));
    ms.hospitals = SetUtil.union(ms.hospitals, SetUtil.set(h2));
    ms.hospitals = SetUtil.union(ms.hospitals, SetUtil.set(h3));
    super.assertEqual(Utils.copy(expected), ms.getDocsMultipleHospitals());
  }

  public void testGetHospitalMostAppointments() {

    hospitalNetwork ms = new hospitalNetwork();
    Hospital h1 = new Hospital("H.S.Joao");
    Hospital h2 = new Hospital("Sta. Maria");
    Hospital h3 = new Hospital("Agostinho Neto");
    Doctor doc1 = new Doctor("Bela");
    Doctor doc2 = new Doctor("Bia");
    Doctor doc3 = new Doctor("Eva");
    Hospital expected = h2;
    IO.println("running testGetHospitalMostAppointments");
    h1.addDoctors(doc1);
    h1.addDoctors(doc2);
    h2.addDoctors(doc1);
    h3.addDoctors(doc3);
    h2.addDoctors(doc3);
    ms.hospitals = SetUtil.union(ms.hospitals, SetUtil.set(h1));
    ms.hospitals = SetUtil.union(ms.hospitals, SetUtil.set(h2));
    ms.hospitals = SetUtil.union(ms.hospitals, SetUtil.set(h3));
    h2.addAppointments(appointment1);
    h2.addAppointments(appointment3);
    h3.addAppointments(appointment2);
    h1.addAppointments(appointment4);
    super.assertEqual(expected, ms.getHospitalMostAppointments());
  }

  public void testAllManagementSys() {

    testGetHospitalDocs();
    testGetDocsMultipleHospitals();
    testGetHospitalMostAppointments();
  }

  public void testAll() {

    testAllDoctor();
    testAllManagementSys();
  }

  public hospitalNetworkTest() {}

  public String toString() {

    return "hospitalNetworkTest{"
        + "network := "
        + Utils.toString(network)
        + ", doctor1 := "
        + Utils.toString(doctor1)
        + ", doctor2 := "
        + Utils.toString(doctor2)
        + ", doctor3 := "
        + Utils.toString(doctor3)
        + ", hospital1 := "
        + Utils.toString(hospital1)
        + ", hospital2 := "
        + Utils.toString(hospital2)
        + ", hospital3 := "
        + Utils.toString(hospital3)
        + ", hospital4 := "
        + Utils.toString(hospital4)
        + ", hospital5 := "
        + Utils.toString(hospital5)
        + ", hospital6 := "
        + Utils.toString(hospital6)
        + ", appointment1 := "
        + Utils.toString(appointment1)
        + ", appointment2 := "
        + Utils.toString(appointment2)
        + ", appointment3 := "
        + Utils.toString(appointment3)
        + ", appointment4 := "
        + Utils.toString(appointment4)
        + "}";
  }
}
