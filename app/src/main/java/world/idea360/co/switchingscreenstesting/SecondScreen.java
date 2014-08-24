package world.idea360.co.switchingscreenstesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by christopher on 8/23/14.
 */
public class SecondScreen extends Activity   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_2);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_text_view);

        callingActivityMessage.append(" " + previousActivity);
    }

    public void onSendUsersName(View view) {
        EditText usersName = (EditText) findViewById(R.id.users_name_edit_text);

        String name = String.valueOf(usersName.getText());

        Intent goingBackToMain = new Intent();

        goingBackToMain.putExtra("name", name);

        setResult(RESULT_OK, goingBackToMain);

        finish();

    }
}
