CREATE TABLE city_info
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255)     NOT NULL,
    latitude  DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    country   VARCHAR(255),
    state     VARCHAR(255)
);

CREATE TABLE weather_report
(
    id                  SERIAL PRIMARY KEY,
    create_date         TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    change_date         TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    city_id             INT              NOT NULL,
    weather_main        VARCHAR(255),
    weather_description VARCHAR(255),
    temp                DOUBLE PRECISION NOT NULL,
    feels_like          DOUBLE PRECISION NOT NULL,
    visibility          INT,
    wind_speed          DOUBLE PRECISION NOT NULL,
    date_time           BIGINT           NOT NULL,
    sys_sunrise         BIGINT,
    sys_sunset          BIGINT,
    time_zone           INT,
    name                VARCHAR(255),
    FOREIGN KEY (city_id) REFERENCES city_info (id) ON DELETE CASCADE
);

CREATE INDEX idx_weather_report_city_id ON weather_report (city_id);
