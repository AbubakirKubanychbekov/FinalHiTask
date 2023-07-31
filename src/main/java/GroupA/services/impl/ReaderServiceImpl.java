package GroupA.services.impl;

import GroupA.entities.Reader;
import GroupA.repo.ReaderRepo;
import GroupA.repo.impl.ReaderRepoImpl;
import GroupA.services.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepo readerRepo=new ReaderRepoImpl();

    @Override
    public String saveReader(Reader reader) {
        return readerRepo.saveReader(reader);
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        return readerRepo.updateReader(id,reader);
    }

    @Override
    public String deleteReaderById(Long id) {
        return readerRepo.deleteReaderById(id);
    }
}
