# language: ru
@course_category
Функционал: Страница категории курса

  Предыстория:
    Дано открываю браузер "chrome"
    Затем открыта главная страница otus в браузере

  Сценарий: Страница курса открывается успешно
    Тогда главная страница открыта и заголовок "Авторские онлайн‑курсы для профессионалов"
    Если кликнуть на категорию курса "Тестирование"
    Затем выбираем курс "Python QA Engineer"

  Сценарий: Найдем курс стартующий после даты
    Тогда главная страница открыта и заголовок "Авторские онлайн‑курсы для профессионалов"
    Если кликнуть на категорию курса "Тестирование"
    Затем выбираем курс стартующий после 27.04.2022

  Сценарий: Выбираем курс "Kotlin Backend Developer"
    Тогда главная страница открыта и заголовок "Авторские онлайн‑курсы для профессионалов"
    Затем в header выбираем тип курса "Подготовительные курсы"
    Когда выбираем самый дешевый курс
    Тогда страница подготовительного курса открыта