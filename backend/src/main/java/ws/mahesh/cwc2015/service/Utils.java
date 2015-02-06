package ws.mahesh.cwc2015.service;

/**
 * Created by Mahesh on 2/6/2015.
 */
public class Utils {

    public static boolean isIntlTeam(String t1) {
        switch (t1) {
            case "India":
            case "England":
            case "Australia":
            case "West Indies":
            case "South Africa":
            case "Sri Lanka":
            case "Pakistan":
            case "United Arab Emirates":
            case "Afganistan":
            case "New Zealand":
            case "Zimbabwe":
            case "Scotland":
            case "Ireland":
            case "Bangladesh":
            case "Andhra Pradesh":
            case "Assam":
            case "Baroda":
            case "Bengal":
            case "Delhi":
            case "Goa":
            case "Gujarat":
            case "Haryana":
            case "Himachal Pradesh":
            case "Hyderabad":
            case "Jammu and Kashmir":
            case "Jharkhand":
            case "Karnataka":
            case "Kerala":
            case "Madhya Pradesh":
            case "Maharashtra":
            case "Mumbai":
            case "Odisha":
            case "Punjab":
            case "Railways":
            case "Rajasthan":
            case "Saurashtra":
            case "Services":
            case "Tamil Nadu":
            case "Tripura":
            case "Uttar Pradesh":
            case "Vidarbha":
                return true;
            default:
                return false;
        }
    }
}
