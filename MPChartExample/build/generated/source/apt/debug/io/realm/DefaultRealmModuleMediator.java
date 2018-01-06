package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(3);
        modelClasses.add(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        modelClasses.add(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        modelClasses.add(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(3);
        infoMap.put(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class, io.realm.RealmFloatRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.xxmassdeveloper.mpchartexample.realm.Score.class, io.realm.ScoreRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class, io.realm.RealmDemoDataRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            return io.realm.RealmFloatRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            return io.realm.ScoreRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            return io.realm.RealmDemoDataRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            return io.realm.RealmFloatRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            return io.realm.ScoreRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            return io.realm.RealmDemoDataRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            return io.realm.RealmFloatRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            return io.realm.ScoreRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            return io.realm.RealmDemoDataRealmProxy.getSimpleClassName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
                return clazz.cast(new io.realm.RealmFloatRealmProxy());
            }
            if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
                return clazz.cast(new io.realm.ScoreRealmProxy());
            }
            if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
                return clazz.cast(new io.realm.RealmDemoDataRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            return clazz.cast(io.realm.RealmFloatRealmProxy.copyOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) obj, update, cache));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            return clazz.cast(io.realm.ScoreRealmProxy.copyOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.realm.Score) obj, update, cache));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            return clazz.cast(io.realm.RealmDemoDataRealmProxy.copyOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            io.realm.RealmFloatRealmProxy.insert(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) object, cache);
        } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            io.realm.ScoreRealmProxy.insert(realm, (com.xxmassdeveloper.mpchartexample.realm.Score) object, cache);
        } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            io.realm.RealmDemoDataRealmProxy.insert(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
                io.realm.RealmFloatRealmProxy.insert(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) object, cache);
            } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
                io.realm.ScoreRealmProxy.insert(realm, (com.xxmassdeveloper.mpchartexample.realm.Score) object, cache);
            } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
                io.realm.RealmDemoDataRealmProxy.insert(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
                    io.realm.RealmFloatRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
                    io.realm.ScoreRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
                    io.realm.RealmDemoDataRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            io.realm.RealmFloatRealmProxy.insertOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) obj, cache);
        } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            io.realm.ScoreRealmProxy.insertOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.realm.Score) obj, cache);
        } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            io.realm.RealmDemoDataRealmProxy.insertOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
                io.realm.RealmFloatRealmProxy.insertOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) object, cache);
            } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
                io.realm.ScoreRealmProxy.insertOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.realm.Score) object, cache);
            } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
                io.realm.RealmDemoDataRealmProxy.insertOrUpdate(realm, (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
                    io.realm.RealmFloatRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
                    io.realm.ScoreRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
                    io.realm.RealmDemoDataRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            return clazz.cast(io.realm.RealmFloatRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            return clazz.cast(io.realm.ScoreRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            return clazz.cast(io.realm.RealmDemoDataRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            return clazz.cast(io.realm.RealmFloatRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            return clazz.cast(io.realm.ScoreRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            return clazz.cast(io.realm.RealmDemoDataRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class)) {
            return clazz.cast(io.realm.RealmFloatRealmProxy.createDetachedCopy((com.xxmassdeveloper.mpchartexample.custom.RealmFloat) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.realm.Score.class)) {
            return clazz.cast(io.realm.ScoreRealmProxy.createDetachedCopy((com.xxmassdeveloper.mpchartexample.realm.Score) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class)) {
            return clazz.cast(io.realm.RealmDemoDataRealmProxy.createDetachedCopy((com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
