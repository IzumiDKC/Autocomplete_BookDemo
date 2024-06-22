package Group8_Week3.DienNguyen.services;

import Group8_Week3.DienNguyen.Entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final List<Book> books;

    public List<Book> getAllBooks() {
        return books;
    }
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void updateBook(Book book) {
        var bookOptional = getBookById(book.getId());
        if (bookOptional.isPresent()) {
            Book bookUpdate = bookOptional.get();
            bookUpdate.setTitle(book.getTitle());
            bookUpdate.setAuthor(book.getAuthor());
            bookUpdate.setPrice(book.getPrice());
            bookUpdate.setCategory(book.getCategory());
        }
    }
    public void deleteBookById(Long id) {
        getBookById(id).ifPresent(books::remove);
    }

    public List<Book> searchBooks(String keyword) {
        String lowerCaseKeyword = keyword.toLowerCase();
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(lowerCaseKeyword) ||
                        book.getAuthor().toLowerCase().contains(lowerCaseKeyword))
                .collect(Collectors.toList());
    }

    public List<String> GoiY(String term) {
        String lowerCaseTerm = term.toLowerCase();
        List<String> GoiYTenSach = books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(lowerCaseTerm))
                .map(Book::getTitle)
                .distinct()
                .collect(Collectors.toList());

        List<String> GoiYTacGia = books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(lowerCaseTerm))
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        GoiYTenSach.addAll(GoiYTacGia);
        return GoiYTenSach;
    }
}