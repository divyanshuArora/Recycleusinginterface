package app.divyanshu.recycleusinginterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements userInterface {

    List<UserModel> userModels = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);


        loadData();


    }

    private void loadData()
    {

        userModels.add(new UserModel("divyanshu","divyanshu.arora8@gmail.com","7737729400"));
        userModels.add(new UserModel("Deepak","Deepak8@gmail.com","7894561230"));
        userModels.add(new UserModel("Aman","Aman@gmail.com","96806806984"));
        userModels.add(new UserModel("Mukund","Mukund@gmail.com","1234567890"));
        userModels.add(new UserModel("Chandu","Chandu@gmail.com","7418529630"));
        userModels.add(new UserModel("Anshul","Anshul@gmail.com","7418965236"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerAdapter = new RecyclerAdapter(getApplicationContext(),userModels,this);
        recyclerView.setAdapter(recyclerAdapter);



    }

    @Override
    public void onITemCklick(UserModel position) {
        Log.d("Main", "onITemCklick: "+position.getEmail());
    }
}
