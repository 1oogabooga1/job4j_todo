CREATE TABLE IF NOT EXISTS categories_tasks (
task_id int REFERENCES tasks(id),
category_id int REFERENCES categories(id),
UNIQUE(task_id, category_id)
);