package GroupA.repo;

import GroupA.entities.Reader;

public interface ReaderRepo {
    String saveReader(Reader reader);
    Reader updateReader(Long id, Reader reader);
    Reader getReaderByBookId();
   String deleteReaderById(Long id);
   void getReadersByAuthorId();
}
