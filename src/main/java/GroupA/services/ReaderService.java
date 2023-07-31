package GroupA.services;

import GroupA.entities.Reader;

public interface ReaderService {
    String saveReader(Reader reader);
    Reader updateReader(Long id, Reader reader);
    String deleteReaderById(Long id);
}
