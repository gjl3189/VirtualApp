package com.lody.virtual.client.hook.patchs.account;

import android.accounts.Account;
import android.accounts.IAccountManagerResponse;

import com.lody.virtual.client.hook.base.Hook;

import java.lang.reflect.Method;

/**
 * @author Lody
 *
 * @see android.accounts.IAccountManager#removeAccount(IAccountManagerResponse, Account, boolean)
 */

public class Hook_RemoveAccount extends Hook<AccountManagerPatch> {
    /**
     * 这个构造器必须有,用于依赖注入.
     *
     * @param patchObject 注入对象
     */
    public Hook_RemoveAccount(AccountManagerPatch patchObject) {
        super(patchObject);
    }

    @Override
    public String getName() {
        return "removeAccount";
    }

    @Override
    public Object onHook(Object who, Method method, Object... args) throws Throwable {
        AccountUtils.replaceAccount(args);
        return method.invoke(who, args);
    }
}
