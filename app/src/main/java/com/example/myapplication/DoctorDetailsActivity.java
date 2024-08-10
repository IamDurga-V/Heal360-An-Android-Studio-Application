package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name: Dr. N. Senthilvel", "Hospital Address: Coimbatore", "Exp: 33 years", "Mobile No: 1234567890", "600"},
            {"Doctor Name: Dr. M.G. Binu", "Hospital Address: Coimbatore", "Exp: 29 years", "Mobile No: 0987654321", "500"},
            {"Doctor Name: Dr. N. Mahendran", "Hospital Address: Coimbatore", "Exp: 20 years", "Mobile No: 1122334455", "800"},
            {"Doctor Name: Dr. A. Murali", "Hospital Address: Coimbatore", "Exp: 20 years", "Mobile No: 2233445566", "600"},
            {"Doctor Name: Dr. P.S. Sadasivam", "Hospital Address: Coimbatore", "Exp: 38 years", "Mobile No: 3344556677", "900"},
            {"Doctor Name: Dr. Sujaya Menon", "Hospital Address: PSG Hospitals, Coimbatore", "Experience: 34 years", "Mobile No: 4455667788", "200"},
            {"Doctor Name: Dr. Saravanan T", "Hospital Address: PSG Hospitals, Coimbatore", "Experience: 19 years", "Mobile No: 5566778899", "650"},
            {"Doctor Name: Dr. Sujith Kumar S", "Hospital Address: PSG Hospitals, Coimbatore", "Experience: 19 years", "Mobile No: 6677889900", "600"},
            {"Doctor Name: Dr. Tolstoy R", "Hospital Address: PSG Hospitals, Coimbatore", "Experience: 21 years", "Mobile No: 7788990011", "1000"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name: Dr. S. Priyanka", "Hospital Address: Chennai", "Exp: 12 years", "Mobile No: 9876543210", "500"},
            {"Doctor Name: Dr. A. Vidhya", "Hospital Address: Coimbatore", "Exp: 10 years", "Mobile No: 8765432109", "600"},
            {"Doctor Name: Dr. K. Lakshmi", "Hospital Address: Madurai", "Exp: 15 years", "Mobile No: 7654321098", "700"},
            {"Doctor Name: Dr. R. Bharathi", "Hospital Address: Trichy", "Exp: 8 years", "Mobile No: 6543210987", "550"},
            {"Doctor Name: Dr. M. Meenakshi", "Hospital Address: Salem", "Exp: 9 years", "Mobile No: 5432109876", "650"},
            {"Doctor Name: Dr. T. Sudha", "Hospital Address: Tirunelveli", "Experience: 11 years", "Mobile No: 4321098765", "600"},
            {"Doctor Name: Dr. V. Radhika", "Hospital Address: Erode", "Experience: 13 years", "Mobile No: 3210987654", "700"},
            {"Doctor Name: Dr. P. Revathi", "Hospital Address: Vellore", "Experience: 10 years", "Mobile No: 2109876543", "500"},
            {"Doctor Name: Dr. C. Uma", "Hospital Address: Thanjavur", "Experience: 14 years", "Mobile No: 1098765432", "600"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name: Dr. P. R. Chockalingam", "Hospital Address: Srishti Dentistry, Chennai", "Exp: 16 years", "Mobile No: 1234567890", "250"},
            {"Doctor Name: Dr. Praveenraj", "Hospital Address: Sri Jairam Dental Care, Erode", "Exp: 17 years", "Mobile No: 0987654321", "600"},
            {"Doctor Name: Dr. Kiruthika Asokan", "Hospital Address: Family Dental Center, Chennai", "Exp: 13 years", "Mobile No: 1122334455", "150"},
            {"Doctor Name: Dr. Koshy Chithresan", "Hospital Address: The Dental Clinic, Coimbatore", "Exp: 33 years", "Mobile No: 2233445566", "600"},
            {"Doctor Name: Dr. R. Pranav Vanajassun", "Hospital Address: Dr Pranav's Clinic, Chennai", "Exp: 19 years", "Mobile No: 3344556677", "600"},
            {"Doctor Name: Dr. Pandurangan Harikrishnan", "Hospital Address: Teeth N Jaws Center, Chennai", "Experience: 36 years", "Mobile No: 4455667788", "600"},
            {"Doctor Name: Dr. Muruganandhan J", "Hospital Address: The Dental Clinic, Chennai", "Experience: 19 years", "Mobile No: 5566778899", "600"},
            {"Doctor Name: Dr. Sivanesan", "Hospital Address: Agaram Dental Clinic, Madurai", "Experience: 16 years", "Mobile No: 6677889900", "600"},
            {"Doctor Name: Dr. K. S. Ashok Kumar", "Hospital Address: Srisakthi Dental Clinic, Coimbatore", "Experience: NA", "Mobile No: 7788990011", "600"},
            {"Doctor Name: Dr. Vikas Gupta", "Hospital Address: Dental Care Professionals, Coimbatore", "Experience: 17 years", "Mobile No: 8899001122", "600"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name: Dr. Muthuvel Rajan", "Hospital Address: Apollo Hospital, Madurai", "Exp: 35 years", "Mobile No: 04522589904", "500"},
            {"Doctor Name: Dr. R. Sivakumar", "Hospital Address: Preethi Hospitals, Madurai", "Exp: 28 years", "Mobile No: 04524219995", "500"},
            {"Doctor Name: Dr. R.P. Shanmugam", "Hospital Address: RPS Hospitals, Chennai", "Exp 54 years", "Mobile No: 1234567890", "300"},
            {"Doctor Name: Dr. T.G. Balachandar", "Hospital Address: Apollo Hospital, Chennai", "Exp: 52 years", "Mobile No: 0987654321", "1000"},
            {"Doctor Name: Dr. Mahesh Sundaram", "Hospital Address: Progress Clinic, Chennai", "Exp: 26 years", "Mobile No: 1122334455", "500"},
            {"Doctor Name: Dr. R. Kamalakannan", "Hospital Address: Padma Jayaram Gastro And Liver Speciality Clinic, Chennai", "Experience: 26 years", "Mobile No: 2233445566", "600"},
            {"Doctor Name: Dr. Anand Ramamurthy", "Hospital Address: Apollo Hospital, Chennai", "Experience: 28 years", "Mobile No: 3344556677", "1000"},
            {"Doctor Name: Dr. T.S. Chandrasekar", "Hospital Address: Sanjeevani Clinic, Chennai", "Experience: 29 years", "Mobile No: 4455667788", "700"},
            {"Doctor Name: Dr. S. Rajendran", "Hospital Address: Apollo Cancer Centres, Chennai", "Experience: 36 years", "Mobile No: 5566778899", "1000"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name: Dr. Muthuvel Rajan", "Hospital Address: Apollo Hospital, Madurai", "Exp: 35 years", "Mobile No: 04522589904", "500"},
            {"Doctor Name: Dr. R. Sivakumar", "Hospital Address: Preethi Hospitals, Madurai", "Exp: 28 years", "Mobile No: 04524219995", "500"},
            {"Doctor Name: Dr. R.P. Shanmugam", "Hospital Address: RPS Hospitals, Chennai", "Exp: 54 years", "Mobile No: 1234567890", "300"},
            {"Doctor Name: Dr. T.G. Balachandar", "Hospital Address: Apollo Hospital, Chennai", "Exp: 52 years", "Mobile No: 0987654321", "1000"},
            {"Doctor Name: Dr. Mahesh Sundaram", "Hospital Address: Progress Clinic, Chennai", "Exp: 26 years", "Mobile No: 1122334455", "500"},
            {"Surgeon Name: Dr. R. Kamalakannan", "Hospital Address: Padma Jayaram Gastro And Liver Speciality Clinic, Chennai", "Experience: 26 years", "Mobile No: 2233445566", "600"},
            {"Surgeon Name: Dr. Anand Ramamurthy", "Hospital Address: Apollo Hospital, Chennai", "Experience: 28 years", "Mobile No: 3344556677", "1000"},
            {"Surgeon Name: Dr. T.S. Chandrasekar", "Hospital Address: Sanjeevani Clinic, Chennai", "Experience: 29 years", "Mobile No: 4455667788", "700"},
            {"Surgeon Name: Dr. S. Rajendran", "Hospital Address: Apollo Cancer Centres, Chennai", "Experience: 36 years", "Mobile No: 5566778899", "1000"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,}
        );
        ListView lst=findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}