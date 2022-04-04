# language: ru
@course_category
Функционал: Страница категории курса

  Сценарий: Страница курса открывается успешно
    Дано открываю браузер "chrome"
    Пусть Открыта главная страница otus в браузере
    Тогда Главная страница открыта и заголовок "Авторские онлайн‑курсы для профессионалов"
    Если Кликнуть на категорию курса "Тестирование"
    Затем выбираем курс "Python QA Engineer"

  Сценарий: Найдем курс стартующий после даты
    Дано открываю браузер "chrome"
    Пусть Открыта главная страница otus в браузере
    Тогда Главная страница открыта и заголовок "Авторские онлайн‑курсы для профессионалов"
    Если Кликнуть на категорию курса "Тестирование"
    Затем выбираем курс стартующий после 27.04.2022

  Сценарий: Найдем курс стартующий в дату
    Дано открываю браузер "chrome"
    Пусть Открыта главная страница otus в браузере
    Тогда Главная страница открыта и заголовок "Авторские онлайн‑курсы для профессионалов"
    Если Кликнуть на категорию курса "Тестирование"
    Затем выбираем курс стартующий после 17.03.2022

  @debug
  Сценарий: Выбираем курс "Kotlin Backend Developer"
    Дано открываю браузер "chrome"
    Затем Открыта главная страница otus в браузере
    Тогда Главная страница открыта и заголовок "Авторские онлайн‑курсы для профессионалов"
    Затем в header выбираем тип курса "Подготовительные курсы"
    Когда выбираем самый дешевый курс
    Тогда страница подготовительного курса открыта