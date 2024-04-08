# Datagrip extractors

## One-row(MultipleColumns).groovy

### One-row vs One-row(MultipleColumns)
| ROW_NUM | CONTENTS | CREATED |
| :--- | :--- | :--- |
| 1 | One | 2024-04-08 12:58:08 |
| 2 | Two | 2024-04-08 12:58:08 |
| 3 | Three | 2024-04-08 12:58:08 |

#### One-row
```
1, 'One', '2024-04-08 12:58:08', 2, 'Two', '2024-04-08 12:58:08', 3, 'Three', '2024-04-08 12:58:08'
```

#### One-row(MultipleColumns)
```
(1, 'One', '2024-04-08 12:58:08'), (2, 'Two', '2024-04-08 12:58:08'), (3, 'Three', '2024-04-08 12:58:08')
```

