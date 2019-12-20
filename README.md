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