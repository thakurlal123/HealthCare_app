package com.thakur.customer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule","","","","50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule","","","","305"},
                    {"Vitamin B Complex Capsules","","","","448"},
                    {"InLife Vitamin E Wheat Germ Oil Capsule","","","","539"},
                    {"Dolo 650 Teblet","","","","30"},
                    {"Crocin 650 Advance Tablet","","","","50"},
                    {"Strepsils Medicatd Lozenges for Sore Throat","","","","40"},
                    {"Tata 1mg Calcium + Vitamin D3","","","","30"},
                    {"Feronia -XT Tablet","","","","130"}

            };
    private String[] package_details = {
            "Building and keeping the bones & teeth streong \n" +
                    "Reducing Fatique/stress and muscular pains \n"+
                    "Boosting immunity and increasing resistance against infection",
            "Cheomium is an essential trace mineral that palys an important role in helping insulinregulat blood glucose.",
            "Provides relief from vitamin B deficiencies\n"+
                    "Helps in formation of red blod cells\n"+
                    "Maintains halthy nervous system",
            "It promotes health as well as skin benifit. \n"+
                    "It healps reduce skin blemish and igmentation.\n"+
                    "It act as safeguard the skin from the harsh UVA sun rays.",
            "Dolo 650 teblet healps relieve pain and fever by bloking the realease of certaimn chemical message responsible for fever and pain.",
            "Helps relieve fever and bring down a heigh temperature \n"+
                    "Suitable for people with a heart condition or high temperature",
            "Relieves nthe symptoms of a bacterial throat infection and soothes the recovery process\n"+
                    "Provide na warm and comforting feeling during sore throat",
            "Reduces the risk of clacium deficiency,Ricket, and Osteoporosis\n"+
                    "Promotes mobility and filixibility of jaints",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"

    };

HashMap<String,String>item;
ArrayList list;
SimpleAdapter sa;
ListView lst;
Button btnBack,btnGoToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBackBM);
        btnGoToCart = findViewById(R.id.buttonGoToCartBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0;i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" + packages[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                        it.putExtra("text1",packages[i][0]);
                        it.putExtra("text2",package_details[i]);
                        it.putExtra("text3",packages[i][4]);
                        startActivity(it);
            }
        });

    }
}