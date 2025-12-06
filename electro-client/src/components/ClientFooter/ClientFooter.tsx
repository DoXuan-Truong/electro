import React from 'react';
import {
  ActionIcon,
  Anchor,
  Box,
  Center,
  Container,
  createStyles,
  Grid,
  Group,
  SegmentedControl,
  Stack,
  Text,
  ThemeIcon,
  useMantineColorScheme,
  useMantineTheme
} from '@mantine/core';
import { ElectroLogo } from 'components';
import {
  BrandFacebook,
  BrandInstagram,
  BrandMastercard,
  BrandTiktok,
  BrandVisa,
  BrandYoutube,
  BuildingBank,
  CurrencyDong,
  Headset,
  Moon,
  Sun
} from 'tabler-icons-react';
import { Link } from 'react-router-dom';

const useStyles = createStyles((theme) => ({
  footer: {
    marginTop: theme.spacing.xl * 2,
    paddingTop: theme.spacing.xl * 2,
    paddingBottom: theme.spacing.xl * 2,
    backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[6] : theme.colors.gray[0],
    borderTop: `1px solid ${theme.colorScheme === 'dark' ? theme.colors.dark[5] : theme.colors.gray[2]}`,
  },

  footerLinks: {
    [theme.fn.smallerThan('md')]: {
      marginTop: theme.spacing.xl,
    },
  },

  afterFooter: {
    marginTop: theme.spacing.xl * 2,
    paddingTop: theme.spacing.xl,
    borderTop: `1px solid ${theme.colorScheme === 'dark' ? theme.colors.dark[4] : theme.colors.gray[2]}`,
  },
}));

function ClientFooter() {
  const theme = useMantineTheme();
  const { classes } = useStyles();

  const { colorScheme, toggleColorScheme } = useMantineColorScheme();

  return (
    <footer className={classes.footer} style={{ position: 'relative' }}>
      <div style={{ position: 'absolute', top: -50, left: 0, width: '100%', overflow: 'hidden', lineHeight: 0 }}>
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none" style={{ position: 'relative', display: 'block', width: 'calc(100% + 1.3px)', height: '50px' }}>
          <path d="M321.39,56.44c58-10.79,114.16-30.13,172-41.86,82.39-16.72,168.19-17.73,250.45-.39C823.78,31,906.67,72,985.66,92.83c70.05,18.48,146.53,26.09,214.34,3V0H0V27.35A600.21,600.21,0,0,0,321.39,56.44Z" fill={theme.colorScheme === 'dark' ? theme.colors.dark[6] : theme.colors.gray[0]}></path>
        </svg>
      </div>
      <Container size="xl">
        <Grid>
          <Grid.Col md={6}>
            <Stack spacing={theme.spacing.lg * 1.75}>
              <ElectroLogo width={135} />
              <Group>
                <Headset size={52} color={theme.colors[theme.primaryColor][6]} strokeWidth={1.25} />
                <Stack spacing={theme.spacing.xs / 4}>
                  <Text size="sm" color="dimmed">Tổng đài hỗ trợ</Text>
                  <Text size="xl">(082) 2234 810</Text>
                </Stack>
              </Group>
              <Stack spacing={theme.spacing.xs / 2}>
                <Text weight={500}>Địa chỉ liên hệ</Text>
                <Text>Số 18 Phố Viên, P.Đức Thắng, Q.Bắc Từ Liêm, TP.Hà Nội</Text>
              </Stack>
              <Group spacing="sm">
                <a href="https://www.facebook.com/do.truong.35728" target="_blank" rel="noopener noreferrer">
                  <ActionIcon color="blue" size="xl" radius="xl" variant="light">
                    <BrandFacebook strokeWidth={1.5} />
                  </ActionIcon>
                </a>
                <a href="https://youtube.com/your-channel" target="_blank" rel="noopener noreferrer">
                  <ActionIcon color="blue" size="xl" radius="xl" variant="light">
                    <BrandYoutube strokeWidth={1.5} />
                  </ActionIcon>
                </a>
                <a href="https://instagram.com/your-ig" target="_blank" rel="noopener noreferrer">
                  <ActionIcon color="blue" size="xl" radius="xl" variant="light">
                    <BrandInstagram strokeWidth={1.5} />
                  </ActionIcon>
                </a>
                <a href="https://www.tiktok.com/@kudoushaki" target="_blank" rel="noopener noreferrer">
                  <ActionIcon color="blue" size="xl" radius="xl" variant="light">
                    <BrandTiktok strokeWidth={1.5} />
                  </ActionIcon>
                </a>
              </Group>
            </Stack>
          </Grid.Col>
          <Grid.Col md={6}>
            <Grid>
              <Grid.Col xs={6} className={classes.footerLinks}>
                <Stack>
                  <Text weight={500}>Hỗ trợ khách hàng</Text>
                  <Stack spacing={theme.spacing.xs}>
                    <Anchor component={Link} to="/">Câu hỏi thường gặp</Anchor>
                    <Anchor component={Link} to="/">Hướng dẫn đặt hàng</Anchor>
                    <Anchor component={Link} to="/">Phương thức vận chuyển</Anchor>
                    <Anchor component={Link} to="/">Chính sách đổi trả</Anchor>
                    <Anchor component={Link} to="/">Chính sách thanh toán</Anchor>
                    <Anchor component={Link} to="/">Giải quyết khiếu nại</Anchor>
                    <Anchor component={Link} to="/">Chính sách bảo mật</Anchor>
                  </Stack>
                </Stack>
              </Grid.Col>
              <Grid.Col xs={6} className={classes.footerLinks}>
                <Stack justify="space-between" sx={{ height: '100%' }}>
                  <Stack>
                    <Text weight={500}>Giới thiệu</Text>
                    <Stack spacing={theme.spacing.xs}>
                      <Anchor component={Link} to="/">Về Công ty</Anchor>
                      <Anchor component={Link} to="/">Tuyển dụng</Anchor>
                      <Anchor component={Link} to="/">Hợp tác</Anchor>
                      <Anchor component={Link} to="/">Liên hệ mua hàng</Anchor>
                    </Stack>
                  </Stack>
                  <Group>
                    <SegmentedControl
                      size="xs"
                      value={colorScheme}
                      onChange={(value: 'light' | 'dark') => toggleColorScheme(value)}
                      data={[
                        {
                          value: 'light',
                          label: (
                            <Center>
                              <Sun size={14} strokeWidth={1.5} />
                              <Box ml={10}>Sáng</Box>
                            </Center>
                          ),
                        },
                        {
                          value: 'dark',
                          label: (
                            <Center>
                              <Moon size={14} strokeWidth={1.5} />
                              <Box ml={10}>Tối</Box>
                            </Center>
                          ),
                        },
                      ]}
                    />
                  </Group>
                </Stack>
              </Grid.Col>
            </Grid>
          </Grid.Col>
        </Grid>
        <Group className={classes.afterFooter} position="apart">
          <Text color="dimmed" size="sm">
            © 2025 Electro Corporation. Đỗ Xuân Trường.
          </Text>
          <Group spacing="xs">
            <ThemeIcon variant="outline" color="gray" sx={{ width: 50, height: 30 }}>
              <BrandVisa strokeWidth={1.5} />
            </ThemeIcon>
            <ThemeIcon variant="outline" color="gray" sx={{ width: 50, height: 30 }}>
              <BrandMastercard strokeWidth={1.5} />
            </ThemeIcon>
            <ThemeIcon variant="outline" color="gray" sx={{ width: 50, height: 30 }}>
              <BuildingBank strokeWidth={1.5} />
            </ThemeIcon>
            <ThemeIcon variant="outline" color="gray" sx={{ width: 50, height: 30 }}>
              <CurrencyDong strokeWidth={1.5} />
            </ThemeIcon>
          </Group>
        </Group>
      </Container>
    </footer>
  );
}

export default React.memo(ClientFooter);
