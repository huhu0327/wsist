package com.huhu.wsist.model

import io.realm.RealmObject

open class UserInfo (
    var login : Boolean = false
) : RealmObject()