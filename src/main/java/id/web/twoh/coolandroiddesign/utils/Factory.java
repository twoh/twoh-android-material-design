package id.web.twoh.coolandroiddesign.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import id.web.twoh.coolandroiddesign.R;

public class Factory {

    public static AlertDialog DialogRegulerYesNo(String title, String prompt, Context ctx, boolean cancelable, DialogInterface.OnClickListener yesOcl)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

        // Set the message show for the Alert time
        builder.setMessage(prompt);

        // Set Alert Title
        builder.setTitle(title);

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(cancelable);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("Yes", yesOcl);

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        return alertDialog;
    }

    public static AlertDialog DialogImageView(int resId, Context ctx){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

        View v = ((Activity)ctx).getLayoutInflater().inflate(R.layout.view_standardiview, null);
        v.findViewById(R.id.iv_standard).setBackgroundResource(resId);
        builder.setView(v);

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(true);

        // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setNegativeButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click no then dialog box is canceled.
            dialog.cancel();
        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        return alertDialog;
    }
}
