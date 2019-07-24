package app.divyanshu.recycleusinginterface;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>
{

    Context context;
    List<UserModel> userModels = new ArrayList<>();

    userInterface userInterface;

    public RecyclerAdapter(Context context, List<UserModel> userModels,userInterface user) {
        this.context = context;
        this.userModels = userModels;
        this.userInterface = user;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.user_item,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder itemViewHolder,final int i)
    {

        itemViewHolder.name.setText(userModels.get(i).getName());
        itemViewHolder.email.setText(userModels.get(i).getEmail());
        itemViewHolder.number.setText(userModels.get(i).getNumber());

        itemViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Log.e("Adapter", "onClick: "+userModels.get(i).getEmail());
                if (userInterface!=null) {
                    userInterface.onITemCklick(userModels.get(i));
                }
            }
        });






    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView name,email,number;
        LinearLayout item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            number = itemView.findViewById(R.id.email);
            item = itemView.findViewById(R.id.item);


        }
    }
}
