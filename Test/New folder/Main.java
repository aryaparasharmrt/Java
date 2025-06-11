import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OrderExtractor {

    public static void main(String[] args) {
        // Sample JSON string
        String jsonString = "{ \"pay_id_details_Result\": { \"error_desc\": \"\", \"pay_id_txn_details_list\": { \"pay_id_txn_details\": [ { \"order_no\": 122471744177408, \"amount\": 1500, \"fees\": 0, \"bill_email\": \"awadhesh.bpcl@gmail.com\", \"order_option_type\": \"OPTDBCRD\", \"tax\": 0, \"bill_name\": \"ShridattaShukla\", \"settlementDate\": \"11-04-2025\", \"bank_ref_no\": 454867, \"date_time\": \"2025-04-09 11:13:29.087\", \"txn_type\": \"Shipped\", \"sub_acc_id\": \"DwellMGGM\", \"ccavenue_ref_no\": 113718382220, \"currency\": \"INR\", \"amt_payable\": 1500 }, { \"order_no\": 121881744180072, \"amount\": 2500, \"fees\": 0, \"bill_email\": \"verasingh@gmail.com\", \"order_option_type\": \"OPTUPI\", \"tax\": 0, \"bill_name\": \"Rajatmahsawari\", \"settlementDate\": \"11-04-2025\", \"bank_ref_no\": 130038480811, \"date_time\": \"2025-04-09 11:57:53.403\", \"txn_type\": \"Shipped\", \"sub_acc_id\": \"DwellMGGM\", \"ccavenue_ref_no\": 113718464894, \"currency\": \"INR\", \"amt_payable\": 2500 }, { \"order_no\": 121421744182840, \"amount\": 4000, \"fees\": 40, \"bill_email\": \"abhinavchandra001@gmail.com\", \"order_option_type\": \"OPTCRDC\", \"tax\": 7.2, \"bill_name\": \"ARCHANASRIVASTVA\", \"settlementDate\": \"11-04-2025\", \"bank_ref_no\": 130997, \"date_time\": \"2025-04-09 12:44:01.403\", \"txn_type\": \"Shipped\", \"sub_acc_id\": \"DwellMGGM\", \"ccavenue_ref_no\": 113718547684, \"currency\": \"INR\", \"amt_payable\": 3952.8 }, { \"order_no\": 121341744194084, \"amount\": 1999, \"fees\": 0, \"bill_email\": \"oshocamp@gmail.com\", \"order_option_type\": \"OPTUPI\", \"tax\": 0, \"bill_name\": \"VIKASHSETH\", \"settlementDate\": \"11-04-2025\", \"bank_ref_no\": 130065503393, \"date_time\": \"2025-04-09 15:51:25.32\", \"txn_type\": \"Shipped\", \"sub_acc_id\": \"DwellMGGM\", \"ccavenue_ref_no\": 113718836757, \"currency\": \"INR\", \"amt_payable\": 1999 }, { \"order_no\": 121701744194899, \"amount\": 3000, \"fees\": 0, \"bill_email\": \"mishrayogendra626@gmail.com\", \"order_option_type\": \"OPTDBCRD\", \"tax\": 0, \"bill_name\": \"AARTIMISHRA\", \"settlementDate\": \"11-04-2025\", \"bank_ref_no\": 711839, \"date_time\": \"2025-04-09 16:04:59.947\", \"txn_type\": \"Shipped\", \"sub_acc_id\": \"DwellMGGM\", \"ccavenue_ref_no\": 113718856517, \"currency\": \"INR\", \"amt_payable\": 3000 } ] } }, \"error_code\": \"\", \"pay_id\": 1482974847 } }";

        // Convert string to JSON object
        JSONObject jsonObject = new JSONObject(jsonString);

        // Get the array of pay_id_txn_details
        JSONArray txnDetails = jsonObject.getJSONObject("pay_id_details_Result")
                                         .getJSONObject("pay_id_txn_details_list")
                                         .getJSONArray("pay_id_txn_details");

        // Create a list to store order_no
        List<Long> orderNumbers = new ArrayList<>();

        // Extract order_no from each object in the array
        for (int i = 0; i < txnDetails.length(); i++) {
            JSONObject txn = txnDetails.getJSONObject(i);
            long orderNo = txn.getLong("order_no");
            orderNumbers.add(orderNo);
        }

        // Print the list of order numbers
        System.out.println("Extracted Order Numbers: " + orderNumbers);
    }
}
