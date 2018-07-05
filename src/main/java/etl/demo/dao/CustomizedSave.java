package etl.demo.dao;

interface CustomizedSave<T> {
    <S extends T> S save(S entity);
}
