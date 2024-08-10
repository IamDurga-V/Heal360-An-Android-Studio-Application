package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages=
            {
                    {"Calcimax 500","","","","50"},
                    {"D-Cal 600","","","","50"},
                    {"Osteo D3 1000IU","","","","50"},
                    {"D-Rise 60K","","","","50"},
                    {"Calcitas-D3","","","","50"},
                    {"Shelcal 500","","","","50"},
                    {"Calcirol Sachet","","","","50"},
                    {"Corcium D3","","","","50"},
                    {"Calci D Max","","","","50"},
                    {"Ultra-D3 1000IU","","","","50"}
            };

    private  String[] package_details={
            "Calcimax 500 is used to prevent or treat low blood calcium levels in people who do not get enough calcium from their diets. It may be used to treat conditions caused by low calcium levels such as bone loss (osteoporosis), weak bones (osteomalacia/rickets), decreased activity of the parathyroid gland (hypoparathyroidism), and a certain muscle disease (latent tetany).",
            "D-Cal 600 is a calcium and vitamin D3 supplement used to treat or prevent low blood calcium levels in people who do not get enough calcium from their diets. It is essential for maintaining healthy bones and teeth.",
            "Osteo D3 1000IU contains vitamin D3 which helps in the absorption of calcium and phosphorous in the body, essential for maintaining strong bones and teeth. It is used to treat and prevent bone disorders such as rickets and osteomalacia.",
            "D-Rise 60K contains vitamin D3 and is used to treat vitamin D3 deficiency and associated conditions such as rickets, osteoporosis, and osteomalacia. It helps in the absorption of calcium and phosphorus in the body.",
            "Calcitas-D3 is used to treat or prevent vitamin D3 deficiency and associated conditions such as rickets, osteomalacia, and osteoporosis. It aids in the proper absorption and use of calcium and phosphate in the body.",
            "Shelcal 500 is a calcium supplement that is used to treat or prevent low blood calcium levels in people who do not get enough calcium from their diets. It is also used in conditions such as osteoporosis, osteomalacia, rickets, and hypoparathyroidism.",
            "Calcirol Sachet contains vitamin D3, which is essential for the absorption of calcium in the body. It is used to treat or prevent bone disorders such as osteoporosis, rickets, and osteomalacia.",
            "Corcium D3 is used to treat or prevent low blood calcium levels in people who do not get enough calcium from their diets. It contains calcium and vitamin D3, which are essential for maintaining healthy bones and teeth.",
            "Calci D Max is a supplement containing calcium and vitamin D3, used to treat or prevent low calcium levels in the blood. It helps in maintaining strong bones and teeth and is used in conditions like osteoporosis and rickets.",
            "Ultra-D3 1000IU contains vitamin D3 and is used to treat or prevent vitamin D deficiency. It helps in the absorption of calcium and phosphorus, essential for maintaining healthy bones and teeth."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack,btnGotoCart;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medicine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lst=findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.buttonBMBack);
        btnGotoCart=findViewById(R.id.buttonBMGoToCart);

        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Cons Fees:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}