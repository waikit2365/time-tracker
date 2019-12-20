### GET /schedule/daily

List all records for selected day

**Query Params**

- `start_at` - timestamp, match date using `DATE(start_at) like '2019-12-12%'`
- `plan_actual` - string, seperate data by plan or actual

**Sample Response** 

```
[
    {
        "id": 1,
        "start_at": "2019-12-12 12:00:00",
        "end_at": "2019-12-12 13:00:00",
        "modify_at": "2019-12-12 14:00:00",
        "plan_actual": "plan",
        "category": "play",
        "description": "game"
    }
]
```

### GET /schedule/{category}

List records by category

**Query Params**

- `start_at` - timestamp, match date using `DATE(start_at) like '2019-12-12%'`
- `plan_actual` - string, seperate data by plan or actual
- `category` - string, group the records by category `category = 'play'`

**Sample Response** 

```
[
    {
        "id": 1,
        "start_at": "2019-12-12 12:00:00",
        "end_at": "2019-12-12 13:00:00",
        "plan_actual": "plan",
        "category": "play"
    }
]
```

---


Restful format

|method |path| action| 
|---|---|---|
| POST | /schedule | create |
| PUT | /schedule/{id} | update |
| DELETE | /schedule/{id} | index | 



### POST /schedule/

Insert new schedule record

**Query Params**

`category_id` varchar - record insert

`description` varchar - record insert

`start_at` timestamp - record insert

`end_at` timestamp - record insert

`created_at` timestamp - record insert

`modify_at` timestamp - record insert

`planOrActual` varchar - record insert

**Sample Response**

``
Insert Successfully
``

---

### PUT /schedule/{id}

Update existing scheduled record

**Query Params**

`id` - int, will search existing record `WHERE id = @paramrequest`

`description` varchar - update description

`end_at` timestamp - update with completed time

`modify_at` timestamp - refresh modify date if any changes is made

`planOrActual` varchar - can be modify if this recors is plan or actual schedule

**Sample Response**

``
Update Successfully
``
or
``
Record not found
``

---


### DELETE /schedule/{id}

Update existing scheduled record

**Query Params**

`id` - int, will search existing record `WHERE id = @paramrequest`

**Sample Response**

``
Record deleted
``
or
``
Record not found
``







