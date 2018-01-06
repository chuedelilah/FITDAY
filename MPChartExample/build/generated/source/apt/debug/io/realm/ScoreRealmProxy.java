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
public class ScoreRealmProxy extends com.xxmassdeveloper.mpchartexample.realm.Score
    implements RealmObjectProxy, ScoreRealmProxyInterface {

    static final class ScoreColumnInfo extends ColumnInfo {
        long totalScoreIndex;
        long scoreNrIndex;
        long playerNameIndex;

        ScoreColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Score");
            this.totalScoreIndex = addColumnDetails("totalScore", objectSchemaInfo);
            this.scoreNrIndex = addColumnDetails("scoreNr", objectSchemaInfo);
            this.playerNameIndex = addColumnDetails("playerName", objectSchemaInfo);
        }

        ScoreColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ScoreColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ScoreColumnInfo src = (ScoreColumnInfo) rawSrc;
            final ScoreColumnInfo dst = (ScoreColumnInfo) rawDst;
            dst.totalScoreIndex = src.totalScoreIndex;
            dst.scoreNrIndex = src.scoreNrIndex;
            dst.playerNameIndex = src.playerNameIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(3);
        fieldNames.add("totalScore");
        fieldNames.add("scoreNr");
        fieldNames.add("playerName");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ScoreColumnInfo columnInfo;
    private ProxyState<com.xxmassdeveloper.mpchartexample.realm.Score> proxyState;

    ScoreRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ScoreColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.xxmassdeveloper.mpchartexample.realm.Score>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$totalScore() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.totalScoreIndex);
    }

    @Override
    public void realmSet$totalScore(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.totalScoreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.totalScoreIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public float realmGet$scoreNr() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.scoreNrIndex);
    }

    @Override
    public void realmSet$scoreNr(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.scoreNrIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.scoreNrIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$playerName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.playerNameIndex);
    }

    @Override
    public void realmSet$playerName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.playerNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.playerNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.playerNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.playerNameIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Score", 3, 0);
        builder.addPersistedProperty("totalScore", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("scoreNr", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("playerName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ScoreColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ScoreColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Score";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.xxmassdeveloper.mpchartexample.realm.Score createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.xxmassdeveloper.mpchartexample.realm.Score obj = realm.createObjectInternal(com.xxmassdeveloper.mpchartexample.realm.Score.class, true, excludeFields);

        final ScoreRealmProxyInterface objProxy = (ScoreRealmProxyInterface) obj;
        if (json.has("totalScore")) {
            if (json.isNull("totalScore")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalScore' to null.");
            } else {
                objProxy.realmSet$totalScore((float) json.getDouble("totalScore"));
            }
        }
        if (json.has("scoreNr")) {
            if (json.isNull("scoreNr")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'scoreNr' to null.");
            } else {
                objProxy.realmSet$scoreNr((float) json.getDouble("scoreNr"));
            }
        }
        if (json.has("playerName")) {
            if (json.isNull("playerName")) {
                objProxy.realmSet$playerName(null);
            } else {
                objProxy.realmSet$playerName((String) json.getString("playerName"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.xxmassdeveloper.mpchartexample.realm.Score createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.xxmassdeveloper.mpchartexample.realm.Score obj = new com.xxmassdeveloper.mpchartexample.realm.Score();
        final ScoreRealmProxyInterface objProxy = (ScoreRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("totalScore")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$totalScore((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalScore' to null.");
                }
            } else if (name.equals("scoreNr")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$scoreNr((float) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'scoreNr' to null.");
                }
            } else if (name.equals("playerName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$playerName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$playerName(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.xxmassdeveloper.mpchartexample.realm.Score copyOrUpdate(Realm realm, com.xxmassdeveloper.mpchartexample.realm.Score object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.xxmassdeveloper.mpchartexample.realm.Score) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.xxmassdeveloper.mpchartexample.realm.Score copy(Realm realm, com.xxmassdeveloper.mpchartexample.realm.Score newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.xxmassdeveloper.mpchartexample.realm.Score) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.xxmassdeveloper.mpchartexample.realm.Score realmObject = realm.createObjectInternal(com.xxmassdeveloper.mpchartexample.realm.Score.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ScoreRealmProxyInterface realmObjectSource = (ScoreRealmProxyInterface) newObject;
        ScoreRealmProxyInterface realmObjectCopy = (ScoreRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$totalScore(realmObjectSource.realmGet$totalScore());
        realmObjectCopy.realmSet$scoreNr(realmObjectSource.realmGet$scoreNr());
        realmObjectCopy.realmSet$playerName(realmObjectSource.realmGet$playerName());
        return realmObject;
    }

    public static long insert(Realm realm, com.xxmassdeveloper.mpchartexample.realm.Score object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetFloat(tableNativePtr, columnInfo.totalScoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$totalScore(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.scoreNrIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$scoreNr(), false);
        String realmGet$playerName = ((ScoreRealmProxyInterface) object).realmGet$playerName();
        if (realmGet$playerName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.playerNameIndex, rowIndex, realmGet$playerName, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        com.xxmassdeveloper.mpchartexample.realm.Score object = null;
        while (objects.hasNext()) {
            object = (com.xxmassdeveloper.mpchartexample.realm.Score) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetFloat(tableNativePtr, columnInfo.totalScoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$totalScore(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.scoreNrIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$scoreNr(), false);
            String realmGet$playerName = ((ScoreRealmProxyInterface) object).realmGet$playerName();
            if (realmGet$playerName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.playerNameIndex, rowIndex, realmGet$playerName, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.xxmassdeveloper.mpchartexample.realm.Score object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetFloat(tableNativePtr, columnInfo.totalScoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$totalScore(), false);
        Table.nativeSetFloat(tableNativePtr, columnInfo.scoreNrIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$scoreNr(), false);
        String realmGet$playerName = ((ScoreRealmProxyInterface) object).realmGet$playerName();
        if (realmGet$playerName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.playerNameIndex, rowIndex, realmGet$playerName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.playerNameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        long tableNativePtr = table.getNativePtr();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.getSchema().getColumnInfo(com.xxmassdeveloper.mpchartexample.realm.Score.class);
        com.xxmassdeveloper.mpchartexample.realm.Score object = null;
        while (objects.hasNext()) {
            object = (com.xxmassdeveloper.mpchartexample.realm.Score) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetFloat(tableNativePtr, columnInfo.totalScoreIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$totalScore(), false);
            Table.nativeSetFloat(tableNativePtr, columnInfo.scoreNrIndex, rowIndex, ((ScoreRealmProxyInterface) object).realmGet$scoreNr(), false);
            String realmGet$playerName = ((ScoreRealmProxyInterface) object).realmGet$playerName();
            if (realmGet$playerName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.playerNameIndex, rowIndex, realmGet$playerName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.playerNameIndex, rowIndex, false);
            }
        }
    }

    public static com.xxmassdeveloper.mpchartexample.realm.Score createDetachedCopy(com.xxmassdeveloper.mpchartexample.realm.Score realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.xxmassdeveloper.mpchartexample.realm.Score unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.xxmassdeveloper.mpchartexample.realm.Score();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.xxmassdeveloper.mpchartexample.realm.Score) cachedObject.object;
            }
            unmanagedObject = (com.xxmassdeveloper.mpchartexample.realm.Score) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ScoreRealmProxyInterface unmanagedCopy = (ScoreRealmProxyInterface) unmanagedObject;
        ScoreRealmProxyInterface realmSource = (ScoreRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$totalScore(realmSource.realmGet$totalScore());
        unmanagedCopy.realmSet$scoreNr(realmSource.realmGet$scoreNr());
        unmanagedCopy.realmSet$playerName(realmSource.realmGet$playerName());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Score = proxy[");
        stringBuilder.append("{totalScore:");
        stringBuilder.append(realmGet$totalScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{scoreNr:");
        stringBuilder.append(realmGet$scoreNr());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{playerName:");
        stringBuilder.append(realmGet$playerName() != null ? realmGet$playerName() : "null");
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
        ScoreRealmProxy aScore = (ScoreRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aScore.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aScore.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aScore.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
