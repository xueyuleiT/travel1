package com.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.jtcxw.glcxw.localbean.MessageBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MESSAGE_BEAN".
*/
public class MessageBeanDao extends AbstractDao<MessageBean, Long> {

    public static final String TABLENAME = "MESSAGE_BEAN";

    /**
     * Properties of entity MessageBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Phone = new Property(2, String.class, "phone", false, "PHONE");
        public final static Property BusinessId = new Property(3, String.class, "BusinessId", false, "BUSINESS_ID");
        public final static Property MessageType = new Property(4, String.class, "MessageType", false, "MESSAGE_TYPE");
        public final static Property PushType = new Property(5, String.class, "PushType", false, "PUSH_TYPE");
        public final static Property Read = new Property(6, int.class, "read", false, "READ");
        public final static Property Time = new Property(7, String.class, "time", false, "TIME");
        public final static Property Type = new Property(8, String.class, "type", false, "TYPE");
        public final static Property Detail = new Property(9, String.class, "detail", false, "DETAIL");
    }


    public MessageBeanDao(DaoConfig config) {
        super(config);
    }
    
    public MessageBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MESSAGE_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"PHONE\" TEXT," + // 2: phone
                "\"BUSINESS_ID\" TEXT," + // 3: BusinessId
                "\"MESSAGE_TYPE\" TEXT," + // 4: MessageType
                "\"PUSH_TYPE\" TEXT," + // 5: PushType
                "\"READ\" INTEGER NOT NULL ," + // 6: read
                "\"TIME\" TEXT," + // 7: time
                "\"TYPE\" TEXT," + // 8: type
                "\"DETAIL\" TEXT);"); // 9: detail
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MESSAGE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MessageBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(3, phone);
        }
 
        String BusinessId = entity.getBusinessId();
        if (BusinessId != null) {
            stmt.bindString(4, BusinessId);
        }
 
        String MessageType = entity.getMessageType();
        if (MessageType != null) {
            stmt.bindString(5, MessageType);
        }
 
        String PushType = entity.getPushType();
        if (PushType != null) {
            stmt.bindString(6, PushType);
        }
        stmt.bindLong(7, entity.getRead());
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(8, time);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(9, type);
        }
 
        String detail = entity.getDetail();
        if (detail != null) {
            stmt.bindString(10, detail);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MessageBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(3, phone);
        }
 
        String BusinessId = entity.getBusinessId();
        if (BusinessId != null) {
            stmt.bindString(4, BusinessId);
        }
 
        String MessageType = entity.getMessageType();
        if (MessageType != null) {
            stmt.bindString(5, MessageType);
        }
 
        String PushType = entity.getPushType();
        if (PushType != null) {
            stmt.bindString(6, PushType);
        }
        stmt.bindLong(7, entity.getRead());
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(8, time);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(9, type);
        }
 
        String detail = entity.getDetail();
        if (detail != null) {
            stmt.bindString(10, detail);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MessageBean readEntity(Cursor cursor, int offset) {
        MessageBean entity = new MessageBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // phone
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // BusinessId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // MessageType
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // PushType
            cursor.getInt(offset + 6), // read
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // time
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // type
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // detail
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MessageBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPhone(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBusinessId(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMessageType(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPushType(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRead(cursor.getInt(offset + 6));
        entity.setTime(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setType(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setDetail(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MessageBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MessageBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MessageBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
