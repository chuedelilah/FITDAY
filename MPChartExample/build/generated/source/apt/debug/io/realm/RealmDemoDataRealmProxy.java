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
public class RealmDemoDataRealmProxy extends com.xxmassdeveloper.mpchartexample.custom.RealmDemoData
    implements RealmObjectProxy, RealmDemoDataRealmProxyInterface {

    static final class RealmDemoDataColumnInfo extends ColumnInfo {
        long yValueIndex;
        long xValueIndex;
        long openIndex;
        long closeIndex;
        long highIndex;
        long lowIndex;
        long bubbleSizeIndex;
        long stackValuesIndex;
        long someStringFieldIndex;
        long labelIndex;

        RealmDemoDataColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("RealmDemoData");
            this.yValueIndex = addColumnDetails("yValue", objectSchemaInfo);
            this.xValueIndex = addColumnDetails("xValue", objectSchemaInfo);
            this.openIndex = addColumnDetails("open", objectSchemaInfo);
            this.closeIndex = addColumnDetails("close", objectSchemaInfo);
            this.highIndex = addColumnDetails("high", objectSchemaInfo);
            this.lowIndex = addColumnDetails("low", objectSchemaInfo);
            this.bubbleSizeIndex = addColumnDetails("bubbleSize", objectSchemaInfo);
            this.stackValuesIndex = addColumnDetails("stackValues", objectSchemaInfo);
            this.someStringFieldIndex = addColumnDetails("someStringField", objectSchemaInfo);
            this.labelIndex = addColumnDetails("label", objectSchemaInfo);
        }

        RealmDemoDataColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RealmDemoDataColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RealmDemoDataColumnInfo src = (RealmDemoDataColumnInfo) rawSrc;
            final RealmDemoDataColumnInfo dst = (RealmDemoDataColumnInfo) rawDst;
            dst.yValueIndex = src.yValueIndex;
            dst.xValueIndex = src.xValueIndex;
            dst.openIndex = src.openIndex;
            dst.closeIndex = src.closeIndex;
            dst.highIndex = src.highIndex;
            dst.lowIndex = src.lowIndex;
            dst.bubbleSizeIndex = src.bubbleSizeIndex;
            dst.stackValuesIndex = src.stackValuesIndex;
            dst.someStringFieldIndex = src.someStringFieldIndex;
            dst.labelIndex = src.labelIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(10);
        fieldNames.add("yValue");
        fieldNames.add("xValue");
        fieldNames.add("open");
        fieldNames.add("close");
        fieldNames.add("high");
        fieldNames.add("low");
        fieldNames.add("bubbleSize");
        fieldNames.add("stackValues");
        fieldNames.add("someStringField");
        fieldNames.add("label");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private RealmDemoDataColumnInfo columnInfo;
    private ProxyState<com.xxmassdeveloper.mpchartexample.custom.RealmDemoData> proxyState;
    private RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> stackValuesRealmList;

    RealmDemoDataRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RealmDemoDataColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.xxmassdeveloper.mpchartexample.custom.RealmDemoData>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$yValue() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.yValueIndex);
    }

    @Override
    public void realmSet$yValue(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.yValueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.yValueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$xValue() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.xValueIndex);
    }

    @Override
    public void realmSet$xValue(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.xValueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.xValueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$open() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.openIndex);
    }

    @Override
    public void realmSet$open(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.openIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.openIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$close() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.closeIndex);
    }

    @Override
    public void realmSet$close(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.closeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.closeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$high() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.highIndex);
    }

    @Override
    public void realmSet$high(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.highIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.highIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$low() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.lowIndex);
    }

    @Override
    public void realmSet$low(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.lowIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.lowIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$bubbleSize() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.bubbleSizeIndex);
    }

    @Override
    public void realmSet$bubbleSize(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.bubbleSizeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.bubbleSizeIndex, value);
    }

    @Override
    public RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> realmGet$stackValues() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (stackValuesRealmList != null) {
            return stackValuesRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.stackValuesIndex);
            stackValuesRealmList = new RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat>(com.xxmassdeveloper.mpchartexample.custom.RealmFloat.class, osList, proxyState.getRealm$realm());
            return stackValuesRealmList;
        }
    }

    @Override
    public void realmSet$stackValues(RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("stackValues")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> original = value;
                value = new RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat>();
                for (com.xxmassdeveloper.mpchartexample.custom.RealmFloat item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.stackValuesIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.xxmassdeveloper.mpchartexample.custom.RealmFloat linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.xxmassdeveloper.mpchartexample.custom.RealmFloat linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$someStringField() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.someStringFieldIndex);
    }

    @Override
    public void realmSet$someStringField(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.someStringFieldIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.someStringFieldIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.someStringFieldIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.someStringFieldIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$label() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.labelIndex);
    }

    @Override
    public void realmSet$label(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.labelIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.labelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.labelIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.labelIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmDemoData", 10, 0);
        builder.addPersistedProperty("yValue", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("xValue", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("open", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("close", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("high", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("low", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("bubbleSize", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedLinkProperty("stackValues", RealmFieldType.LIST, "RealmFloat");
        builder.addPersistedProperty("someStringField", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("label", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmDemoDataColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RealmDemoDataColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "RealmDemoData";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.xxmassdeveloper.mpchartexample.custom.RealmDemoData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("stackValues")) {
            excludeFields.add("stackValues");
        }
        com.xxmassdeveloper.mpchartexample.custom.RealmDemoData obj = realm.createObjectInternal(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class, true, excludeFields);

        final RealmDemoDataRealmProxyInterface objProxy = (RealmDemoDataRealmProxyInterface) obj;
        if (json.has("yValue")) {
            if (json.isNull("yValue")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'yValue' to null.");
            } else {
                objProxy.realmSet$yValue((float) json.getDouble("yValue"));
            }
        }
        if (json.has("xValue")) {
            if (json.isNull("xValue")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'xValue' to null.");
            } else {
                objProxy.realmSet$xValue((float) json.getDouble("xValue"));
            }
        }
        if (json.has("open")) {
            if (json.isNull("open")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'open' to null.");
            } else {
                objProxy.realmSet$open((float) json.getDouble("open"));
            }
        }
        if (json.has("close")) {
            if (json.isNull("close")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'close' to null.");
            } else {
                objProxy.realmSet$close((float) json.getDouble("close"));
            }
        }
        if (json.has("high")) {
            if (json.isNull("high")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'high' to null.");
            } else {
                objProxy.realmSet$high((float) json.getDouble("high"));
            }
        }
        if (json.has("low")) {
            if (json.isNull("low")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'low' to null.");
            } else {
                objProxy.realmSet$low((float) json.getDouble("low"));
            }
        }
        if (json.has("bubbleSize")) {
            if (json.isNull("bubbleSize")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'bubbleSize' to null.");
            } else {
                objProxy.realmSet$bubbleSize((float) json.getDouble("bubbleSize"));
            }
        }
        if (json.has("stackValues")) {
            if (json.isNull("stackValues")) {
                objProxy.realmSet$stackValues(null);
            } else {
                objProxy.realmGet$stackValues().clear();
                JSONArray array = json.getJSONArray("stackValues");
                for (int i = 0; i < array.length(); i++) {
                    com.xxmassdeveloper.mpchartexample.custom.RealmFloat item = RealmFloatRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$stackValues().add(item);
                }
            }
        }
        if (json.has("someStringField")) {
            if (json.isNull("someStringField")) {
                objProxy.realmSet$someStringField(null);
            } else {
                objProxy.realmSet$someStringField((String) json.getString("someStringField"));
            }
        }
        if (json.has("label")) {
            if (json.isNull("label")) {
                objProxy.realmSet$label(null);
            } else {
                objProxy.realmSet$label((String) json.getString("label"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.xxmassdeveloper.mpchartexample.custom.RealmDemoData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.xxmassdeveloper.mpchartexample.custom.RealmDemoData obj = new com.xxmassdeveloper.mpchartexample.custom.RealmDemoData();
        final RealmDemoDataRealmProxyInterface objProxy = (RealmDemoDataRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("yValue")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$yValue((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'yValue' to null.");
                }
            } else if (name.equals("xValue")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$xValue((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'xValue' to null.");
                }
            } else if (name.equals("open")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$open((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'open' to null.");
                }
            } else if (name.equals("close")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$close((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'close' to null.");
                }
            } else if (name.equals("high")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$high((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'high' to null.");
                }
            } else if (name.equals("low")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$low((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'low' to null.");
                }
            } else if (name.equals("bubbleSize")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$bubbleSize((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'bubbleSize' to null.");
                }
            } else if (name.equals("stackValues")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$stackValues(null);
                } else {
                    objProxy.realmSet$stackValues(new RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.xxmassdeveloper.mpchartexample.custom.RealmFloat item = RealmFloatRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$stackValues().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("someStringField")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$someStringField((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$someStringField(null);
                }
            } else if (name.equals("label")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$label((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$label(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.xxmassdeveloper.mpchartexample.custom.RealmDemoData copyOrUpdate(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmDemoData object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.xxmassdeveloper.mpchartexample.custom.RealmDemoData copy(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmDemoData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.xxmassdeveloper.mpchartexample.custom.RealmDemoData realmObject = realm.createObjectInternal(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        RealmDemoDataRealmProxyInterface realmObjectSource = (RealmDemoDataRealmProxyInterface) newObject;
        RealmDemoDataRealmProxyInterface realmObjectCopy = (RealmDemoDataRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$yValue(realmObjectSource.realmGet$yValue());
        realmObjectCopy.realmSet$xValue(realmObjectSource.realmGet$xValue());
        realmObjectCopy.realmSet$open(realmObjectSource.realmGet$open());
        realmObjectCopy.realmSet$close(realmObjectSource.realmGet$close());
        realmObjectCopy.realmSet$high(realmObjectSource.realmGet$high());
        realmObjectCopy.realmSet$low(realmObjectSource.realmGet$low());
        realmObjectCopy.realmSet$bubbleSize(realmObjectSource.realmGet$bubbleSize());

        RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> stackValuesList = realmObjectSource.realmGet$stackValues();
        if (stackValuesList != null) {
            RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> stackValuesRealmList = realmObjectCopy.realmGet$stackValues();
            stackValuesRealmList.clear();
            for (int i = 0; i < stackValuesList.size(); i++) {
                com.xxmassdeveloper.mpchartexample.custom.RealmFloat stackValuesItem = stackValuesList.get(i);
                com.xxmassdeveloper.mpchartexample.custom.RealmFloat cachestackValues = (com.xxmassdeveloper.mpchartexample.custom.RealmFloat) cache.get(stackValuesItem);
                if (cachestackValues != null) {
                    stackValuesRealmList.add(cachestackValues);
                } else {
                    stackValuesRealmList.add(RealmFloatRealmProxy.copyOrUpdate(realm, stackValuesItem, update, cache));
                }
            }
        }

        realmObjectCopy.realmSet$someStringField(realmObjectSource.realmGet$someStringField());
        realmObjectCopy.realmSet$label(realmObjectSource.realmGet$label());
        return realmObject;
    }

    public static long insert(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmDemoData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        long tableNativePtr = table.getNativePtr();
        RealmDemoDataColumnInfo columnInfo = (RealmDemoDataColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetFloat(tableNativePtr, columnInfo.yValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$yValue(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.xValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$xValue(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$open(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.closeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$close(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.highIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$high(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.lowIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$low(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.bubbleSizeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$bubbleSize(), false);

        RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> stackValuesList = ((RealmDemoDataRealmProxyInterface) object).realmGet$stackValues();
        if (stackValuesList != null) {
            OsList stackValuesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.stackValuesIndex);
            for (com.xxmassdeveloper.mpchartexample.custom.RealmFloat stackValuesItem : stackValuesList) {
                Long cacheItemIndexstackValues = cache.get(stackValuesItem);
                if (cacheItemIndexstackValues == null) {
                    cacheItemIndexstackValues = RealmFloatRealmProxy.insert(realm, stackValuesItem, cache);
                }
                stackValuesOsList.addRow(cacheItemIndexstackValues);
            }
        }
        String realmGet$someStringField = ((RealmDemoDataRealmProxyInterface) object).realmGet$someStringField();
        if (realmGet$someStringField != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.someStringFieldIndex, rowIndex, realmGet$someStringField, false);
        }
        String realmGet$label = ((RealmDemoDataRealmProxyInterface) object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        long tableNativePtr = table.getNativePtr();
        RealmDemoDataColumnInfo columnInfo = (RealmDemoDataColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        com.xxmassdeveloper.mpchartexample.custom.RealmDemoData object = null;
        while (objects.hasNext()) {
            object = (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetFloat(tableNativePtr, columnInfo.yValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$yValue(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.xValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$xValue(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$open(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.closeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$close(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.highIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$high(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.lowIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$low(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.bubbleSizeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$bubbleSize(), false);

            RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> stackValuesList = ((RealmDemoDataRealmProxyInterface) object).realmGet$stackValues();
            if (stackValuesList != null) {
                OsList stackValuesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.stackValuesIndex);
                for (com.xxmassdeveloper.mpchartexample.custom.RealmFloat stackValuesItem : stackValuesList) {
                    Long cacheItemIndexstackValues = cache.get(stackValuesItem);
                    if (cacheItemIndexstackValues == null) {
                        cacheItemIndexstackValues = RealmFloatRealmProxy.insert(realm, stackValuesItem, cache);
                    }
                    stackValuesOsList.addRow(cacheItemIndexstackValues);
                }
            }
            String realmGet$someStringField = ((RealmDemoDataRealmProxyInterface) object).realmGet$someStringField();
            if (realmGet$someStringField != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.someStringFieldIndex, rowIndex, realmGet$someStringField, false);
            }
            String realmGet$label = ((RealmDemoDataRealmProxyInterface) object).realmGet$label();
            if (realmGet$label != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.xxmassdeveloper.mpchartexample.custom.RealmDemoData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        long tableNativePtr = table.getNativePtr();
        RealmDemoDataColumnInfo columnInfo = (RealmDemoDataColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetFloat(tableNativePtr, columnInfo.yValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$yValue(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.xValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$xValue(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$open(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.closeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$close(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.highIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$high(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.lowIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$low(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.bubbleSizeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$bubbleSize(), false);

        OsList stackValuesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.stackValuesIndex);
        RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> stackValuesList = ((RealmDemoDataRealmProxyInterface) object).realmGet$stackValues();
        if (stackValuesList != null && stackValuesList.size() == stackValuesOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = stackValuesList.size();
            for (int i = 0; i < objects; i++) {
                com.xxmassdeveloper.mpchartexample.custom.RealmFloat stackValuesItem = stackValuesList.get(i);
                Long cacheItemIndexstackValues = cache.get(stackValuesItem);
                if (cacheItemIndexstackValues == null) {
                    cacheItemIndexstackValues = RealmFloatRealmProxy.insertOrUpdate(realm, stackValuesItem, cache);
                }
                stackValuesOsList.setRow(i, cacheItemIndexstackValues);
            }
        } else {
            stackValuesOsList.removeAll();
            if (stackValuesList != null) {
                for (com.xxmassdeveloper.mpchartexample.custom.RealmFloat stackValuesItem : stackValuesList) {
                    Long cacheItemIndexstackValues = cache.get(stackValuesItem);
                    if (cacheItemIndexstackValues == null) {
                        cacheItemIndexstackValues = RealmFloatRealmProxy.insertOrUpdate(realm, stackValuesItem, cache);
                    }
                    stackValuesOsList.addRow(cacheItemIndexstackValues);
                }
            }
        }

        String realmGet$someStringField = ((RealmDemoDataRealmProxyInterface) object).realmGet$someStringField();
        if (realmGet$someStringField != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.someStringFieldIndex, rowIndex, realmGet$someStringField, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.someStringFieldIndex, rowIndex, false);
        }
        String realmGet$label = ((RealmDemoDataRealmProxyInterface) object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        long tableNativePtr = table.getNativePtr();
        RealmDemoDataColumnInfo columnInfo = (RealmDemoDataColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData.class);
        com.xxmassdeveloper.mpchartexample.custom.RealmDemoData object = null;
        while (objects.hasNext()) {
            object = (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetFloat(tableNativePtr, columnInfo.yValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$yValue(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.xValueIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$xValue(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.openIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$open(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.closeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$close(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.highIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$high(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.lowIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$low(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.bubbleSizeIndex, rowIndex, ((RealmDemoDataRealmProxyInterface) object).realmGet$bubbleSize(), false);

            OsList stackValuesOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.stackValuesIndex);
            RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> stackValuesList = ((RealmDemoDataRealmProxyInterface) object).realmGet$stackValues();
            if (stackValuesList != null && stackValuesList.size() == stackValuesOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = stackValuesList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.xxmassdeveloper.mpchartexample.custom.RealmFloat stackValuesItem = stackValuesList.get(i);
                    Long cacheItemIndexstackValues = cache.get(stackValuesItem);
                    if (cacheItemIndexstackValues == null) {
                        cacheItemIndexstackValues = RealmFloatRealmProxy.insertOrUpdate(realm, stackValuesItem, cache);
                    }
                    stackValuesOsList.setRow(i, cacheItemIndexstackValues);
                }
            } else {
                stackValuesOsList.removeAll();
                if (stackValuesList != null) {
                    for (com.xxmassdeveloper.mpchartexample.custom.RealmFloat stackValuesItem : stackValuesList) {
                        Long cacheItemIndexstackValues = cache.get(stackValuesItem);
                        if (cacheItemIndexstackValues == null) {
                            cacheItemIndexstackValues = RealmFloatRealmProxy.insertOrUpdate(realm, stackValuesItem, cache);
                        }
                        stackValuesOsList.addRow(cacheItemIndexstackValues);
                    }
                }
            }

            String realmGet$someStringField = ((RealmDemoDataRealmProxyInterface) object).realmGet$someStringField();
            if (realmGet$someStringField != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.someStringFieldIndex, rowIndex, realmGet$someStringField, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.someStringFieldIndex, rowIndex, false);
            }
            String realmGet$label = ((RealmDemoDataRealmProxyInterface) object).realmGet$label();
            if (realmGet$label != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
            }
        }
    }

    public static com.xxmassdeveloper.mpchartexample.custom.RealmDemoData createDetachedCopy(com.xxmassdeveloper.mpchartexample.custom.RealmDemoData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.xxmassdeveloper.mpchartexample.custom.RealmDemoData unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.xxmassdeveloper.mpchartexample.custom.RealmDemoData();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) cachedObject.object;
            }
            unmanagedObject = (com.xxmassdeveloper.mpchartexample.custom.RealmDemoData) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        RealmDemoDataRealmProxyInterface unmanagedCopy = (RealmDemoDataRealmProxyInterface) unmanagedObject;
        RealmDemoDataRealmProxyInterface realmSource = (RealmDemoDataRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$yValue(realmSource.realmGet$yValue());
        unmanagedCopy.realmSet$xValue(realmSource.realmGet$xValue());
        unmanagedCopy.realmSet$open(realmSource.realmGet$open());
        unmanagedCopy.realmSet$close(realmSource.realmGet$close());
        unmanagedCopy.realmSet$high(realmSource.realmGet$high());
        unmanagedCopy.realmSet$low(realmSource.realmGet$low());
        unmanagedCopy.realmSet$bubbleSize(realmSource.realmGet$bubbleSize());

        // Deep copy of stackValues
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$stackValues(null);
        } else {
            RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> managedstackValuesList = realmSource.realmGet$stackValues();
            RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat> unmanagedstackValuesList = new RealmList<com.xxmassdeveloper.mpchartexample.custom.RealmFloat>();
            unmanagedCopy.realmSet$stackValues(unmanagedstackValuesList);
            int nextDepth = currentDepth + 1;
            int size = managedstackValuesList.size();
            for (int i = 0; i < size; i++) {
                com.xxmassdeveloper.mpchartexample.custom.RealmFloat item = RealmFloatRealmProxy.createDetachedCopy(managedstackValuesList.get(i), nextDepth, maxDepth, cache);
                unmanagedstackValuesList.add(item);
            }
        }
        unmanagedCopy.realmSet$someStringField(realmSource.realmGet$someStringField());
        unmanagedCopy.realmSet$label(realmSource.realmGet$label());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RealmDemoData = proxy[");
        stringBuilder.append("{yValue:");
        stringBuilder.append(realmGet$yValue());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{xValue:");
        stringBuilder.append(realmGet$xValue());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{open:");
        stringBuilder.append(realmGet$open());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{close:");
        stringBuilder.append(realmGet$close());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{high:");
        stringBuilder.append(realmGet$high());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{low:");
        stringBuilder.append(realmGet$low());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{bubbleSize:");
        stringBuilder.append(realmGet$bubbleSize());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stackValues:");
        stringBuilder.append("RealmList<RealmFloat>[").append(realmGet$stackValues().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{someStringField:");
        stringBuilder.append(realmGet$someStringField() != null ? realmGet$someStringField() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{label:");
        stringBuilder.append(realmGet$label() != null ? realmGet$label() : "null");
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
        RealmDemoDataRealmProxy aRealmDemoData = (RealmDemoDataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRealmDemoData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRealmDemoData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRealmDemoData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
