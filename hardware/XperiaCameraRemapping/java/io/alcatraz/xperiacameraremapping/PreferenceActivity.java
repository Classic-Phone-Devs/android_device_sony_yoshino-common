package io.alcatraz.xperiacameraremapping;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import androidx.annotation.Nullable;
import android.provider.Settings;
import android.view.MenuItem;

public class PreferenceActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perference);

        String enabledServicesBuilder = "io.alcatraz.xperiacameraremapping/io.alcatraz.xperiacameraremapping.MainService";
        boolean accessibilityEnabled = true;
        Settings.Secure.putString(getContentResolver(), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES, enabledServicesBuilder.toString());
        Settings.Secure.putInt(getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED, accessibilityEnabled ? 1 : 0);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.preference_act_fragment_container, new MainFragment())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
