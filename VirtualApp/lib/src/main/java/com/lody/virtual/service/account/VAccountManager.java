package com.lody.virtual.service.account;

import android.accounts.Account;
import android.accounts.AuthenticatorDescription;
import android.accounts.IAccountManagerResponse;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.RemoteException;

import com.lody.virtual.helper.utils.XLog;
import com.lody.virtual.service.IAccountManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Lody
 *
 * TODO: Implement Account & Sync System.
 *
 */

public class VAccountManager extends IAccountManager.Stub {

    private static final String TAG = VAccountManager.class.getSimpleName();

    public class AuthRecord {
        public AuthenticatorDescription description;
        public ServiceInfo serviceInfo;

        public AuthRecord(AuthenticatorDescription authenticatorDescription, ServiceInfo serviceInfo) {
            this.description = authenticatorDescription;
            this.serviceInfo = serviceInfo;
        }
    }

    private static final VAccountManager sService = new VAccountManager();

    public static VAccountManager getService() {
        return sService;
    }

    @Override
    public String getPassword(Account account) throws RemoteException {
        return null;
    }

    @Override
    public String getUserData(Account account, String key) throws RemoteException {
        return null;
    }

    @Override
    public AuthenticatorDescription[] getAuthenticatorTypes(int userId) throws RemoteException {
        return new AuthenticatorDescription[0];
    }

    @Override
    public Account[] getAccounts(String accountType, String opPackageName) throws RemoteException {
        return new Account[0];
    }

    @Override
    public Account[] getAccountsForPackage(String packageName, int uid, String opPackageName) throws RemoteException {
        return new Account[0];
    }

    @Override
    public Account[] getAccountsByTypeForPackage(String type, String packageName, String opPackageName) throws RemoteException {
        return new Account[0];
    }

    @Override
    public Account[] getAccountsAsUser(String accountType, int userId, String opPackageName) throws RemoteException {
        return new Account[0];
    }

    @Override
    public void hasFeatures(IAccountManagerResponse response, Account account, String[] features, String opPackageName) throws RemoteException {

    }

    @Override
    public void getAccountsByFeatures(IAccountManagerResponse response, String accountType, String[] features, String opPackageName) throws RemoteException {

    }

    @Override
    public boolean addAccountExplicitly(Account account, String password, Bundle extras) throws RemoteException {
        if (!isValidAccount(account)) {
            XLog.d(TAG, "addAccountExplicitly failed : invalid account.");
            return false;
        }
        Set<String> keySet = extras.keySet();
        Map<String, String> extra = new HashMap<>(keySet.size());
        for (String key : keySet) {
            String value = extras.getString(key);
            if (value != null) {
                extra.put(key, value);
            }
        }
        AccountRecord r = new AccountRecord(account, extra);
        // TODO: Insert data to Database
        return true;
    }

    private boolean isValidAccount(Account account) {
        return account != null && account.name != null && account.type != null;
    }

    @Override
    public void removeAccount(IAccountManagerResponse response, Account account, boolean expectActivityLaunch) throws RemoteException {

    }

    @Override
    public void removeAccountAsUser(IAccountManagerResponse response, Account account, boolean expectActivityLaunch, int userId) throws RemoteException {

    }

    @Override
    public boolean removeAccountExplicitly(Account account) throws RemoteException {
        return false;
    }

    @Override
    public void copyAccountToUser(IAccountManagerResponse response, Account account, int userFrom, int userTo) throws RemoteException {

    }

    @Override
    public void invalidateAuthToken(String accountType, String authToken) throws RemoteException {

    }

    @Override
    public String peekAuthToken(Account account, String authTokenType) throws RemoteException {
        return null;
    }

    @Override
    public void setAuthToken(Account account, String authTokenType, String authToken) throws RemoteException {

    }

    @Override
    public void setPassword(Account account, String password) throws RemoteException {

    }

    @Override
    public void clearPassword(Account account) throws RemoteException {

    }

    @Override
    public void setUserData(Account account, String key, String value) throws RemoteException {

    }

    @Override
    public void updateAppPermission(Account account, String authTokenType, int uid, boolean value) throws RemoteException {

    }

    @Override
    public void getAuthToken(IAccountManagerResponse response, Account account, String authTokenType, boolean notifyOnAuthFailure, boolean expectActivityLaunch, Bundle options) throws RemoteException {

    }

    @Override
    public void addAccount(IAccountManagerResponse response, String accountType, String authTokenType, String[] requiredFeatures, boolean expectActivityLaunch, Bundle options) throws RemoteException {

    }

    @Override
    public void addAccountAsUser(IAccountManagerResponse response, String accountType, String authTokenType, String[] requiredFeatures, boolean expectActivityLaunch, Bundle options, int userId) throws RemoteException {

    }

    @Override
    public void updateCredentials(IAccountManagerResponse response, Account account, String authTokenType, boolean expectActivityLaunch, Bundle options) throws RemoteException {

    }

    @Override
    public void editProperties(IAccountManagerResponse response, String accountType, boolean expectActivityLaunch) throws RemoteException {

    }

    @Override
    public void confirmCredentialsAsUser(IAccountManagerResponse response, Account account, Bundle options, boolean expectActivityLaunch, int userId) throws RemoteException {

    }

    @Override
    public boolean accountAuthenticated(Account account) throws RemoteException {
        return false;
    }

    @Override
    public void getAuthTokenLabel(IAccountManagerResponse response, String accountType, String authTokenType) throws RemoteException {

    }

    @Override
    public boolean addSharedAccountAsUser(Account account, int userId) throws RemoteException {
        return false;
    }

    @Override
    public Account[] getSharedAccountsAsUser(int userId) throws RemoteException {
        return new Account[0];
    }

    @Override
    public boolean removeSharedAccountAsUser(Account account, int userId) throws RemoteException {
        return false;
    }

    @Override
    public void renameAccount(IAccountManagerResponse response, Account accountToRename, String newName) throws RemoteException {

    }

    @Override
    public String getPreviousName(Account account) throws RemoteException {
        return null;
    }

    @Override
    public boolean renameSharedAccountAsUser(Account accountToRename, String newName, int userId) throws RemoteException {
        return false;
    }
}
