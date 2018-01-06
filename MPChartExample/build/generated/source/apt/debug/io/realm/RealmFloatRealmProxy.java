package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class RealmFloatRealmProxy extends com.xxmassdeveloper.mpchartexample.custom.RealmFloat
    implements RealmObjectProxy, RealmFloatRealmProxyInterface {

    static final class RealmFloatColumnInfo extends ColumnInfo {
        long floatValueIndex;

        RealmFloatColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmFloat");
            this.floatValueIndex = addColumnDetails("floatValue", objectSchemaInfo);
        }

        RealmFloatColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmFloatColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmFloatColumnInfo src = (RealmFloatColumnInfo) rawSrc;
            final RealmFloatColumnInfo dst = (RealmFloatColumnInfo) rawDst;
            dst.floatValueIndex = src.floatValueIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(1);
        fieldNames.add("floatValue");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmFloatColumnInfo columnInfo;
    private ProxyState<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> proxyState;

    RealmFloatRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmFloatColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.xxmassdeveloper.mpchartexample.custom.RealmFloat>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$floatValue() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.floatValueIndex);
    }

    @Override
    public void realmSet$floatValue(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.floatValueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.floatValueIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmFloat", 1, 0);
        builder.addPersistedProperty("floatValue", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmFloatColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmFloatColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmFloat";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.xxmassdeveloper.mpchartexample.custom.RealmFloat createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.xxmassdeveloper.mpchartexample.custom.RealmFloat obj = realm.createObjectInternal(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class, true, excludeFields);

        final RealmFloatRealmProxyInterface objProxy = (RealmFloatRealmProxyInterface) obj;
        if (json.has("floatValue")) {
            if (json.isNull("floatValue")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'floatValue' to null.");
            } else {
                objProxy.realmSet$floatValue((float) json.getDouble("floatValue"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.xxmassdeveloper.mpchartexample.custom.RealmFloat createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.xxmassdeveloper.mpchartexample.custom.RealmFloat obj = new com.xxmassdeveloper.mpchartexample.custom.RealmFloat();
        final RealmFloatRealmProxyInterface objProxy = (RealmFloatRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("floatValue")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$floatValue((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'floatValue' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.xxmassdeveloper.mpchartexample.custom.RealmFloat copyOrUpdate(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmFloat object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.xxmassdeveloper.mpchartexample.custom.RealmFloat copy(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmFloat newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.xxmassdeveloper.mpchartexample.custom.RealmFloat realmObject = realm.createObjectInternal(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmFloatRealmProxyInterface realmObjectSource = (RealmFloatRealmProxyInterface) newObject;
        RealmFloatRealmProxyInterface realmObjectCopy = (RealmFloatRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$floatValue(realmObjectSource.realmGet$floatValue());
        return realmObject;
    }

    public static long insert(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmFloat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        long tableNativePtr = table.getNativePtr();
        RealmFloatColumnInfo columnInfo = (RealmFloatColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetFloat(tableNativePtr, columnInfo.floatValueIndex, rowIndex, ((RealmFloatRealmProxyInterface) object).realmGet$floatValue(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        long tableNativePtr = table.getNativePtr();
        RealmFloatColumnInfo columnInfo = (RealmFloatColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        com.xxmassdeveloper.mpchartexample.custom.RealmFloat object = null;
        while (objects.hasNext()) {
            object = (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetFloat(tableNativePtr, columnInfo.floatValueIndex, rowIndex, ((RealmFloatRealmProxyInterface) object).realmGet$floatValue(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmFloat object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        long tableNativePtr = table.getNativePtr();
        RealmFloatColumnInfo columnInfo = (RealmFloatColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetFloat(tableNativePtr, columnInfo.floatValueIndex, rowIndex, ((RealmFloatRealmProxyInterface) object).realmGet$floatValue(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        long tableNativePtr = table.getNativePtr();
        RealmFloatColumnInfo columnInfo = (RealmFloatColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class);
        com.xxmassdeveloper.mpchartexample.custom.RealmFloat object = null;
        while (objects.hasNext()) {
            object = (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetFloat(tableNativePtr, columnInfo.floatValueIndex, rowIndex, ((RealmFloatRealmProxyInterface) object).realmGet$floatValue(), false);
        }
    }

    public static com.xxmassdeveloper.mpchartexample.custom.RealmFloat createDetachedCopy(com.xxmassdeveloper.mpchartexample.custom.RealmFloat realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.xxmassdeveloper.mpchartexample.custom.RealmFloat unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.xxmassdeveloper.mpchartexample.custom.RealmFloat();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) cachedObject.object;
            }
            unmanagedObject = (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmFloatRealmProxyInterface unmanagedCopy = (RealmFloatRealmProxyInterface) unmanagedObject;
        RealmFloatRealmProxyInterface realmSource = (RealmFloatRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$floatValue(realmSource.realmGet$floatValue());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmFloat = proxy[");
        stringBuilder.append("{floatValue:");
        stringBuilder.append(realmGet$floatValue());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealmFloatRealmProxy aRealmFloat = (RealmFloatRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmFloat.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmFloat.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmFloat.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
