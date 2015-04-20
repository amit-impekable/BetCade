package com.betcade.android.market.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class BetCadeService extends IntentService {
    private static final String TAG  = BetCadeService.class.getSimpleName();

    // TODO: Define all parameters
    private static final String PARAM_APPLICATION_ID = TAG + ".application.id";
    private static final String PARAM_USER_ID = TAG + ".user.id";

    // TODO: Define additional startup helpers
    public static void startInstall(Context context, int appId) {
        Intent intent = new Intent(context, BetCadeService.class);
        intent.setAction(ACTIONS.INSTALL.getValue());
        intent.putExtra(PARAM_APPLICATION_ID, appId);
        context.startService(intent);
    }

    public static void startUninstall(Context context, int appId) {
        Intent intent = new Intent(context, BetCadeService.class);
        intent.setAction(ACTIONS.UNINSTALL.getValue());
        intent.putExtra(PARAM_APPLICATION_ID, appId);
        context.startService(intent);
    }

    public static void startUpdate(Context context, int appId) {
        Intent intent = new Intent(context, BetCadeService.class);
        intent.setAction(ACTIONS.UPDATE.getValue());
        intent.putExtra(PARAM_APPLICATION_ID, appId);
        context.startService(intent);
    }

    public static void startRefresh(Context context, int userId) {
        Intent intent = new Intent(context, BetCadeService.class);
        intent.setAction(ACTIONS.REFRESH.getValue());
        intent.putExtra(PARAM_APPLICATION_ID, userId);
        context.startService(intent);
    }

    public BetCadeService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final int appId = intent.getIntExtra(PARAM_APPLICATION_ID, -1);
            final int userId = intent.getIntExtra(PARAM_USER_ID, -1);
            final String action = intent.getAction();
            switch (ACTIONS.byValue(action)) {
                case INSTALL:
                    handleInstall(appId);
                    break;
                case UNINSTALL:
                    handleUninstall(appId);
                    break;
                case UPDATE:
                    handleUpdate(appId);
                    break;
                case REFRESH:
                    handleRefresh(userId);
                    break;
            }
        }
    }

    // TODO: Define all handlers
    private void handleInstall(int appId) {
        // TODO: Handle action
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void handleUninstall(int appId) {
        // TODO: Handle action
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void handleUpdate(int appId) {
        // TODO: Handle action
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void handleRefresh(int userId) {
        // TODO: Handle action
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Defined actions available to this service
     */
    private static enum ACTIONS {
        UNKNOWN(TAG + ".UNKNOWN"),
        INSTALL(TAG + ".INSTALL"),
        UNINSTALL(TAG + ".UNINSTALL"),
        UPDATE(TAG + ".UPDATE"),
        REFRESH(TAG + ".REFRESH");

        private String value;

        private ACTIONS(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public static ACTIONS byValue(String search) {
            for (ACTIONS a : values())
                if (a.value.equals(search))
                    return a;
            return UNKNOWN;
        }
    }
}
